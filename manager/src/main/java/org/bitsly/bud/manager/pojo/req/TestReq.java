package org.bitsly.bud.manager.pojo.req;

import lombok.Data;
import org.hibernate.validator.constraints.SafeHtml;

@Data
public class TestReq {
    @SafeHtml
    private String html;
}
