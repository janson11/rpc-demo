package org.janson.core;

/**
 * @Description:
 * @Author: Janson
 * @Date: 2022/3/15 21:48
 **/
public class RpcServiceHelper {
    public static String buildServiceKey(String serviceName, String serviceVersion) {
        return String.join("#", serviceName, serviceVersion);
    }
}
