package org.janson.core;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @Author: Janson
 * @Date: 2022/3/15 21:39
 **/
@Data
public class RpcRequest implements Serializable {

    private String serviceVersion;
    private String className;
    private String methodName;
    private Object[] params;
    private Class<?>[] parameterTypes;


}
