package org.janson.test.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: Janson
 * @Date: 2022/3/16 19:21
 **/
public class CglibTransactionProxy implements MethodInterceptor {

    private Object target;

    public CglibTransactionProxy(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib start transaction");
        Object result = methodProxy.invokeSuper(object, objects);
        System.out.println("cglib submit transaction");
        return result;
    }
}
