package org.janson.protocol.protocol;


import lombok.Getter;

/**
 * @Description:
 * @Author: Janson
 * @Date: 2022/3/15 11:50
 **/
public enum MsgStatus {

    SUCESS(0),
    FAIL(1);

    /**
     * 消息状态
     */
    @Getter
    private final int code;

    MsgStatus(int code) {
        this.code = code;
    }
}
