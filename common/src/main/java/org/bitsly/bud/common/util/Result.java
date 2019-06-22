package org.bitsly.bud.common.util;

public class Result<T> {
    private Boolean success;
    private String code;
    private String message;
    private T data;

    public Boolean success() {
        return success;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    private static String queryMsg(Integer code) {
        return ContextUtil.getContext().getMessage('C'+ String.valueOf(code),
                null,
                LocaleUtil.getLocale());
    }

    public static <E> Result<E> success(E data) {
        Result<E> result = new Result<E>();
        result.success = true;
        result.code = "0";
        result.message = queryMsg(0);
        result.data = data;
        return result;
    }

    public static <E> Result<E> fail(Integer code) {
        Result<E> result = new Result<E>();
        result.success = false;
        result.code = String.valueOf(code);
        result.message = queryMsg(code);
        result.data = null;
        return result;
    }

    public static <E> Result<E> fail(Integer code, E data) {
        Result<E> result = new Result<E>();
        result.success = false;
        result.code = String.valueOf(code);
        result.message = queryMsg(code);
        result.data = data;
        return result;
    }
}
