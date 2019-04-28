package org.bitsly.bud.manager.controller;

import org.apache.commons.text.StringEscapeUtils;
import org.bitsly.bud.manager.pojo.req.TestReq;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TestController {

    @PostMapping("/test")
    public Object test(@RequestBody @Valid TestReq req) {
        return StringEscapeUtils.escapeHtml4(req.getHtml());
    }
}
