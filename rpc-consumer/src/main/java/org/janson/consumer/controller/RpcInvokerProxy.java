package org.janson.consumer.controller;

import io.netty.channel.DefaultEventLoop;
import io.netty.util.concurrent.DefaultPromise;
import org.janson.core.RpcFuture;
import org.janson.core.RpcRequest;
import org.janson.core.RpcRequestHolder;
import org.janson.core.RpcResponse;
import org.janson.protocol.protocol.MsgHeader;
import org.janson.protocol.protocol.MsgType;
import org.janson.protocol.protocol.ProtocolConstants;
import org.janson.protocol.protocol.RpcProtocol;
import org.janson.protocol.serialization.SerializationTypeEnum;
import org.janson.registry.RegistryService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: Janson
 * @Date: 2022/3/16 12:14
 **/
public class RpcInvokerProxy implements InvocationHandler {
    private final String serviceVersion;
    private final long timeout;
    private final RegistryService registryService;

    public RpcInvokerProxy(String serviceVersion, long timeout, RegistryService registryService) {
        this.serviceVersion = serviceVersion;
        this.timeout = timeout;
        this.registryService = registryService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RpcProtocol<RpcRequest> protocol = new RpcProtocol<>();
        MsgHeader header = new MsgHeader();
        long requestId = RpcRequestHolder.REQUEST_ID_GEN.incrementAndGet();
        header.setMagic(ProtocolConstants.MAGIC);
        header.setVersion(ProtocolConstants.VERSION);
        header.setRequestId(requestId);
        header.setSerialization((byte) SerializationTypeEnum.HESSIAN.getType());
        header.setMsgType((byte) MsgType.REQUEST.getType());
        header.setStatus((byte) 0x1);
        protocol.setHeader(header);

        RpcRequest request = new RpcRequest();
        request.setServiceVersion(this.serviceVersion);
        request.setClassName(method.getDeclaringClass().getName());
        request.setMethodName(method.getName());

        request.setParameterTypes(method.getParameterTypes());
        request.setParams(args);
        protocol.setBody(request);

        RpcConsumer rpcConsumer = new RpcConsumer();
        RpcFuture<RpcResponse> future = new RpcFuture<>(new DefaultPromise<>(new DefaultEventLoop()), timeout);
        RpcRequestHolder.REQUEST_MAP.put(requestId, future);
        rpcConsumer.sendRequest(protocol, this.registryService);
        return future.getPromise().get(future.getTimeout(), TimeUnit.SECONDS).getData();
    }
}
