package org.bitsly.bud.wms.service;

import com.alibaba.dubbo.config.annotation.Reference;
import javax.annotation.PostConstruct;
import org.bitsly.bud.base.api.ConfigService;
import org.springframework.stereotype.Component;

/**
 * Created by liuhuan on 2019/1/28.
 */
@Component
public class SayHelloServiceImpl {

    @Reference(url = "dubbo://127.0.0.1:20880")
    private ConfigService configService;

    @PostConstruct
    public void sy() {
        System.out.println(configService.sayHello() + "------------------------------");
    }
}
