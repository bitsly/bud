package org.bitsly.bud.base.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.bitsly.bud.base.service.HealthService;


@Service(protocol="dubbo")
public class HealthServiceImpl implements HealthService {
    @Override
    public String ping() {
        return "pong";
    }
}
