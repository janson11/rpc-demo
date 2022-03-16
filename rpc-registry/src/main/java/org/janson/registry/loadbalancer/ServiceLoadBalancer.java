package org.janson.registry.loadbalancer;

import java.util.List;

/**
 * @Description:
 * @Author: Janson
 * @Date: 2022/3/16 8:20
 **/
public interface ServiceLoadBalancer<T> {
    T select(List<T> servers, int hashCode);
}
