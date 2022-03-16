package org.janson.consumer.controller.controller;

import org.janson.consumer.controller.annotation.RpcReference;
import org.janson.facade.HelloFacade;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Janson
 * @Date: 2022/3/14 12:15
 **/
@RestController
public class HelloController {

    @RpcReference(serviceVersion = "1.0.0", timeout = 3000)
    private HelloFacade helloFacade;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello() {
        return helloFacade.hello("mini rpc");
    }

}
