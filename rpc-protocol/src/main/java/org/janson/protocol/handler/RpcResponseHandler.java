package org.janson.protocol.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.janson.core.RpcFuture;
import org.janson.core.RpcRequestHolder;
import org.janson.core.RpcResponse;
import org.janson.protocol.protocol.RpcProtocol;

/**
 * @Description:
 * @Author: Janson
 * @Date: 2022/3/16 9:24
 **/
public class RpcResponseHandler extends SimpleChannelInboundHandler<RpcProtocol<RpcResponse>> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RpcProtocol<RpcResponse> msg) throws Exception {
        long requestId = msg.getHeader().getRequestId();
        RpcFuture<RpcResponse> future = RpcRequestHolder.REQUEST_MAP.remove(requestId);
        future.getPromise().setSuccess(msg.getBody());
    }
}
