package org.bitsly.bud.base.controller;

import org.bitsly.bud.base.req.CommonReq;
import org.bitsly.bud.common.util.Result;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidController {

    @GetMapping("/get")
    public Result test(@ModelAttribute @Validated CommonReq req) {
        return Result.success("hi");
    }
}
