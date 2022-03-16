package org.janson.provider.facade;

import org.janson.facade.HelloFacade;
import org.janson.provider.annotation.RpcService;

/**
 * @Description:
 * @Author: Janson
 * @Date: 2022/3/14 11:19
 **/
@RpcService(serviceInterface = HelloFacade.class, serviceVersion = "1.0.0")
public class HelloFacadeImpl implements HelloFacade {

    @Override
    public String hello(String name) {
        return "hello" + name;
    }
}
