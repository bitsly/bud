package org.bitsly.bud.common.exception;

public class BizException extends RuntimeException{
    private Integer code;

    public BizException(Integer code) {
        super();
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
