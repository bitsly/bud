package org.bitsly.bud.base.controller;

import org.bitsly.bud.base.api.InfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class InfoController {
    @Resource
    private InfoService infoService;

    @GetMapping("/information")
    public Object info() {
        throw new RuntimeException();
    }
}
