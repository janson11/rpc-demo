package org.janson.protocol.serialization;

import java.io.IOException;

/**
 * @Description:
 * @Author: Janson
 * @Date: 2022/3/15 17:36
 **/
public interface RpcSerialization {

    <T> byte[] serialize(T obj) throws IOException;

    <T> T deserialize(byte[] data,Class<T> clz) throws IOException;
}
