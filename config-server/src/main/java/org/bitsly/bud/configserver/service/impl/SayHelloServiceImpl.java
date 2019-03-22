package org.bitsly.bud.configserver.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.bitsly.bud.configserver.service.SayHelloService;

/**
 * Created by liuhuan on 22/03/2019.
 */
@Service
public class SayHelloServiceImpl implements SayHelloService{

    @Override
    public String sayHello() {
        return "how are you";
    }
}
