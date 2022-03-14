package org.janson.consumer.controller.annotation;

import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description:
 * @Author: Janson
 * @Date: 2022/3/14 17:52
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Autowired
public @interface RpcReference {

    String serviceVersion() default "1.0";

    String registryType() default "ZOOKEEPER";

    String registryAddress() default "127.0.0.1:2181";

    long tiemout() default 5000;


}