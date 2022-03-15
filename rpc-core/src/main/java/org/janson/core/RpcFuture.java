package org.janson.core;

import io.netty.util.concurrent.Promise;
import lombok.Data;

/**
 * @Description:
 * @Author: Janson
 * @Date: 2022/3/15 21:47
 **/
@Data
public class RpcFuture<T> {
    private Promise<T> promise;
    private long timeout;

    public RpcFuture(Promise<T> promise, long timeout) {
        this.promise = promise;
        this.timeout = timeout;
    }
}
