package org.janson.registry;

import org.janson.core.ServiceMeta;

/**
 * @Description:
 * @Author: Janson
 * @Date: 2022/3/14 22:51
 **/
public interface RegistryService {

    void register(ServiceMeta serviceMeta) throws Exception;

    void unRegister(ServiceMeta serviceMeta) throws Exception;

    ServiceMeta discovery(String serviceName, int invokerHashCode) throws Exception;

    void destory() throws Exception;

}
