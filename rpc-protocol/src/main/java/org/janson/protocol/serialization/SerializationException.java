package org.janson.protocol.serialization;

/**
 * @Description:
 * @Author: Janson
 * @Date: 2022/3/15 18:13
 **/
public class SerializationException extends RuntimeException {

    public SerializationException() {
        super();
    }

    public SerializationException(String msg) {
        super(msg);
    }

    public SerializationException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public SerializationException(Throwable cause) {
        super(cause);
    }


}
