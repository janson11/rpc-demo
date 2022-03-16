package org.janson.test.proxy.cglib;

import org.janson.test.proxy.common.UserDao;
import org.janson.test.proxy.common.UserDaoImpl;

/**
 * @Description: Cglib 动态代理是基于 ASM 字节码生成框架实现的第三方工具类库，相比于 JDK 动态代理，Cglib 动态代理更加灵活，
 * 它是通过字节码技术生成的代理类，所以代理类的类型是不受限制的。
 * 使用 Cglib 代理的目标类无须实现任何接口，可以做到对目标类零侵入。
 * <p>
 * Cglib 动态代理是对指定类以字节码的方式生成一个子类，并重写其中的方法，
 * 以此来实现动态代理。因为 Cglib 动态代理创建的是目标类的子类，所以目标类必须要有无参构造函数，而且目标类不要用 final 进行修饰。
 * <p>
 * Cglib 动态代理的实现需要依赖两个核心组件：MethodInterceptor 接口和 Enhancer 类，类似于 JDK 动态代理中的InvocationHandler 接口和Proxy 类。
 * @Author: Janson
 * @Date: 2022/3/16 19:26
 **/
public class CglibTransactionProxyTest {

    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        UserDao proxyInstance = (UserDao) new CglibTransactionProxy(userDao).getProxyInstance();
        proxyInstance.insert();
    }
}
