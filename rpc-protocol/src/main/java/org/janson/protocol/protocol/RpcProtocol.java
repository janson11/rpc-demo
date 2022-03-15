package org.janson.protocol.protocol;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @Author: Janson
 * @Date: 2022/3/15 11:41
 **/
@Data
public class RpcProtocol<T> implements Serializable {
    private MsgHeader header;
    private T body;
}
