package org.bitsly.bud.base.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.bitsly.bud.base.service.PingService;

@Service
public class PingServiceImpl implements PingService {
    @Override
    public String ping() {
        return "pong";
    }
}
