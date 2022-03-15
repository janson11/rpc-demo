package org.janson.core;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @Author: Janson
 * @Date: 2022/3/15 21:45
 **/
@Data
public class RpcResponse implements Serializable {

    private Object data;
    private String message;

}
