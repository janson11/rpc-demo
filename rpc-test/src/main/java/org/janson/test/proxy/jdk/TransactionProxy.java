package org.janson.test.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @Description:
 * @Author: Janson
 * @Date: 2022/3/16 19:07
 **/
public class TransactionProxy {
    private Object target;

    public TransactionProxy(Object target) {
        this.target = target;
    }


    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("start transaction");
                    Object result = method.invoke(target, args);
                    System.out.println("submit transaction");
                    return result;
                });
    }


}
