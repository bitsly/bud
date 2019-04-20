package org.bitsly.bud.base.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.bitsly.bud.base.service.HelloService;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHi() {
        return "hi";
    }
}
