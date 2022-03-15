package org.janson.protocol.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;
import org.janson.core.RpcRequest;
import org.janson.core.RpcResponse;
import org.janson.core.RpcServiceHelper;
import org.janson.protocol.protocol.MsgHeader;
import org.janson.protocol.protocol.MsgStatus;
import org.janson.protocol.protocol.MsgType;
import org.janson.protocol.protocol.RpcProtocol;
import org.springframework.cglib.reflect.FastClass;

import java.util.Map;

/**
 * @Description:
 * @Author: Janson
 * @Date: 2022/3/15 22:03
 **/
@Slf4j
public class RpcRequestHandler extends SimpleChannelInboundHandler<RpcProtocol<RpcRequest>> {

    private final Map<String, Object> rpcServiceMap;

    public RpcRequestHandler(Map<String, Object> rpcServiceMap) {
        this.rpcServiceMap = rpcServiceMap;
    }

    /**
     * @param ctx
     * @param protocol
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RpcProtocol<RpcRequest> protocol) throws Exception {
        RpcRequestProcessor.submitRequest(() -> {
            RpcProtocol<RpcResponse> resProtocol = new RpcProtocol<>();
            RpcResponse response = new RpcResponse();
            MsgHeader header = protocol.getHeader();
            header.setMsgType((byte) MsgType.RESPONSE.getType());
            try {
                Object result = handle(protocol.getBody());
                response.setData(result);

                header.setStatus((byte) MsgStatus.SUCESS.getCode());
                resProtocol.setHeader(header);
                resProtocol.setBody(response);
            } catch (Exception e) {
                header.setStatus((byte) MsgStatus.FAIL.getCode());
                response.setMessage(e.toString());
                log.error("process request {} error", header.getRequestId(), e);
            }
            ctx.writeAndFlush(resProtocol);
        });

    }

    private Object handle(RpcRequest request) throws Exception {
        String serviceKey = RpcServiceHelper.buildServiceKey(request.getClassName(), request.getServiceVersion());
        Object serviceBean = rpcServiceMap.get(serviceKey);
        if (serviceBean == null) {
            throw new RuntimeException(String.format("service not exist:%s:%s", request.getClassName(), request.getMethodName()));
        }
        Class<?> serviceClass = serviceBean.getClass();
        String methodName = request.getMethodName();
        Class<?>[] parameterTypes = request.getParameterTypes();
        Object[] params = request.getParams();
        FastClass fastClass = FastClass.create(serviceClass);
        int methodIndex = fastClass.getIndex(methodName, parameterTypes);
        return fastClass.invoke(methodIndex, serviceBean, params);
    }

}
