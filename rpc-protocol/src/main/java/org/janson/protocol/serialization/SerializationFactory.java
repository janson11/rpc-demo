package org.janson.protocol.serialization;

/**
 * @Description:
 * @Author: Janson
 * @Date: 2022/3/15 17:36
 **/
public class SerializationFactory {

    public static RpcSerialization getRpcSerialization(byte serializationType) {

        SerializationTypeEnum typeEnum = SerializationTypeEnum.findByType(serializationType);
        switch (typeEnum) {
            case HESSIAN:
                return new HessionSerialization();

            case JSON:
                return new JsonSerialization();

            default:
                throw new IllegalArgumentException("serialization type is illegal," + serializationType);
        }
    }
}
