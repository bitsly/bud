package org.bitsly.bud.base.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.bitsly.bud.base.service.RestService;

@Service(protocol="rest")
public class RestServiceImpl implements RestService {
    @Override
    public String ping() {
        return "pong";
    }
}
