package org.bitsly.bud.manager.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.bitsly.bud.base.api.InfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {
    @Reference
    private InfoService infoService;

    @GetMapping("/information")
    public Object info() {
        return infoService.getInfo();
    }
}
