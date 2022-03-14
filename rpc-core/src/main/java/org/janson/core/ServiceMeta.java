package org.janson.core;

import lombok.Data;

/**
 * @Description:
 * @Author: Janson
 * @Date: 2022/3/14 22:52
 **/
@Data
public class ServiceMeta {

    private String serviceName;
    private String serviceVersion;
    private String serviceAddr;
    private int servicePort;

}
