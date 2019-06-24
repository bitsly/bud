package org.bitsly.bud.common.handler;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.bitsly.bud.common.constant.Code;
import org.bitsly.bud.common.exception.BizException;
import org.bitsly.bud.common.util.Result;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * 处理应用代码级别的错误,
 * 处理已知的异常和自定义的异常
 */
@Slf4j
@ResponseBody
@ControllerAdvice
public class ExceptionsHandler {


    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {MethodArgumentNotValidException.class, BindException.class})
    public Result validBean(HttpServletRequest req, Exception e) throws Exception {
        //获取返回值
        BindingResult bindingResult = null;
        if (e instanceof MethodArgumentNotValidException) {
            bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();
        } else if (e instanceof BindException) {
            bindingResult = ((BindException) e).getBindingResult();
        }

        //全局error
        List<ObjectError> globalErrors = bindingResult.getGlobalErrors();
        if (CollectionUtils.isNotEmpty(globalErrors)) {
            for (ObjectError error : globalErrors) {
                return Result.fail(Code.C400, error.getDefaultMessage());
            }
        }

        //属性error
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        if (CollectionUtils.isNotEmpty(fieldErrors)) {
            for (FieldError error : fieldErrors) {
                return Result.fail(Code.C400, error.getDefaultMessage());
            }
        }
        log.error("校验异常");
        return Result.fail(Code.C500, null);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = ConstraintViolationException.class)
    public Result validParam(HttpServletRequest req, ConstraintViolationException e) {
        String message = e.getConstraintViolations().iterator().next().getMessage();
        return Result.fail(Code.C400, message);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @ExceptionHandler(value = BizException.class)
    public Result fail(HttpServletRequest req, BizException e) {
        return Result.fail(e.getCode(), null);
    }
}
