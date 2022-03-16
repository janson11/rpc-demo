package org.janson.core;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description:
 * @Author: Janson
 * @Date: 2022/3/15 21:41
 **/
public class RpcRequestHolder {

    public static final AtomicLong REQUEST_ID_GEN = new AtomicLong(0);

    public static final Map<Long, RpcFuture<RpcResponse>> REQUEST_MAP = new ConcurrentHashMap<>();
}
