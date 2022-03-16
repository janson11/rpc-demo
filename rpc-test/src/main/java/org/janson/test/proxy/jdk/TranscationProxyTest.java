package org.janson.test.proxy.jdk;

import org.janson.test.proxy.common.UserDao;
import org.janson.test.proxy.common.UserDaoImpl;

/**
 * @Description:
 *
 * JDK 动态代理
 * JDK 动态代理实现依赖 java.lang.reflect 包中的两个核心类：InvocationHandler 接口和Proxy 类。
 *
 * JDK 动态代理所代理的对象必须实现一个或者多个接口，生成的代理类也是接口的实现类，然后通过 JDK 动态代理是通过反射调用的方式代理类中的方法，不能代理接口中不存在的方法。
 * 每一个动态代理对象必须提供 InvocationHandler 接口的实现类，InvocationHandler 接口中只有一个 invoke() 方法
 *
 * @Author: Janson
 * @Date: 2022/3/16 19:15
 **/
public class TranscationProxyTest {

    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        UserDao proxyInstance = (UserDao) new TransactionProxy(userDao).getProxyInstance();
        proxyInstance.insert();
    }
}
