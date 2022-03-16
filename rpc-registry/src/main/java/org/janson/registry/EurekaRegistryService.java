package org.janson.registry;

import org.janson.core.ServiceMeta;

/**
 * @Description:
 * @Author: Janson
 * @Date: 2022/3/16 8:38
 **/
public class EurekaRegistryService implements RegistryService {
    public EurekaRegistryService(String registryAddr) {
    }

    @Override
    public void register(ServiceMeta serviceMeta) throws Exception {

    }

    @Override
    public void unRegister(ServiceMeta serviceMeta) throws Exception {

    }

    @Override
    public ServiceMeta discovery(String serviceName, int invokerHashCode) throws Exception {
        return null;
    }

    @Override
    public void destory() throws Exception {

    }
}
