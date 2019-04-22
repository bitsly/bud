package org.bitsly.bud.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import org.bitsly.bud.base.pojo.entity.KVConfigEntity;
import org.bitsly.bud.base.service.KVConfigService;
import org.bitsly.bud.base.service.PingService;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class PingController {
    @Reference
    private PingService pingService;
    @Reference
    private KVConfigService kvConfigService;

    @GetMapping("/ping")
    public Object ping() {
        return pingService.ping();
    }

    @GetMapping("/config")
    public Object config() {
        KVConfigEntity show = kvConfigService.show("test");
        System.out.println(JSON.toJSONString(show));
        return show;
    }
}
