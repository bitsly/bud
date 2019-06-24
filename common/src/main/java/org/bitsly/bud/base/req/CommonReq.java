package org.bitsly.bud.base.req;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class CommonReq {
    @Max(2)
    private Long id;
    @Min(1)
    private Long star;
}
