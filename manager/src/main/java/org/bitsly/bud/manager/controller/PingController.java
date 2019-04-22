package org.bitsly.bud.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.bitsly.bud.base.service.PingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class PingController {
    @Value("${abc}")
    private String abc;
    @Reference
    private PingService pingService;

    @GetMapping("/ping")
    public Object ping() {
        return pingService.ping() + "  " + abc;
    }
}
