package org.janson.protocol.protocol;


import lombok.Getter;

/**
 * @Description:
 * @Author: Janson
 * @Date: 2022/3/15 11:50
 **/
public enum MsgType {

    REQUEST(1),
    RESPONSE(2),
    HEARTBEAT(3);

    /**
     * 消息状态
     */
    @Getter
    private final int type;

    MsgType(int type) {
        this.type = type;
    }

    public static MsgType findByType(int type) {
        for (MsgType msgType : MsgType.values()) {
            if (msgType.getType() == type) {
                return msgType;
            }
        }
        return null;
    }
}
