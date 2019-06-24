package org.bitsly.bud.common.util;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.bitsly.bud.common.exception.BizException;

@Data
public class Result<T> {
    private Boolean success;
    private String code;
    private String message;
    private T data;

    private static String queryMsg(Integer code) {
        return ContextUtil.getContext().getMessage('C'+ String.valueOf(code),
                null,
                LocaleUtil.getLocale());
    }

    public static <E> Result<E> success() {
        Result<E> result = new Result<>();
        result.success = true;
        result.code = "0";
        result.message = queryMsg(0);
        result.data = null;
        return result;
    }

    public static <E> Result<E> success(E data) {
        Result<E> result = new Result<>();
        result.success = true;
        result.code = "0";
        result.message = queryMsg(0);
        result.data = data;
        return result;
    }

    public static void fail(Integer code) {
        throw new BizException(code);
    }

    public static <E> Result<E> fail(Integer code, String msg) {
        Result<E> result = new Result<>();
        result.success = false;
        result.code = String.valueOf(code);
        if (StringUtils.isBlank(msg)) {
            result.message = queryMsg(code);
        }else {
            result.message = msg;
        }
        result.data = null;
        return result;
    }
}
