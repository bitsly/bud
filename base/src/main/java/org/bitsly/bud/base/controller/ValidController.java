package org.bitsly.bud.base.controller;

import org.bitsly.bud.common.annotation.Name;
import org.bitsly.bud.common.util.Result;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;

@Validated
@RestController
public class ValidController {

    @PostMapping("/post")
    public Result test(@RequestParam("id") @Max(2) @Name("{C400}") Long id) {
        return Result.success("hi");
    }
}
