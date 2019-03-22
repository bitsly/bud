package org.bitsly.bud.manager.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.bitsly.bud.manager.service.SayHelloService;

/**
 * Created by liuhuan on 2019/1/28.
 */
@Service(version = "1.0.0")
public class SayHelloServiceImpl implements SayHelloService {
    @Override
    public String sayHello(String name) {
        return String.format("[%s] : Hello, %s", "aaaaaaa", name);
    }

}
