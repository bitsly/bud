package org.bitsly.bud.wms.service;

import org.bitsly.bud.base.api.ConfigService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by liuhuan on 2019/1/28.
 */
@Component
public class SayHelloServiceImpl {

    private ConfigService configService;

    @PostConstruct
    public void sy() {
        System.out.println(configService.sayHello() + "------------------------------");
    }
}
