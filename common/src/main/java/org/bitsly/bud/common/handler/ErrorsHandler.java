package org.bitsly.bud.common.handler;

import org.bitsly.bud.common.constant.Code;
import org.bitsly.bud.common.util.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * 处理web容器和框架级别的错误
 * 处理未捕获的代码逻辑异常和框架的运行时异常，同时会直接在这个地方被打印出来
 * 可处理@ControllerAdvice捕获不到的错误
 * 默认的错误处理机制将不再生效。相比继承BasicErrorController更具有完全的控制权
 * <p>
 * ErrorController： 调用 UserController 抛出异常时，自身没有做任何处理，所以会打印出堆栈信息，但这个异常会被 Servlet 容器捕捉到，Servlet 容器再将请求转发给注册好的异常处理映射 /error 做处理，客户端收到的实际是 ErrorController 的处理结果，而不是 UserController 的。
 * ExceptionHandler： 异常的处理方法直接被定义在 UserController 里面，也就是说，在异常抛出的时候，UserController 会使用自己的方法去做异常处理，而不会抛出给 Servlet 容器，所以这个地方没有打印堆栈信息。
 */
@Controller
@RequestMapping(value = {"${server.error.path:${error.path:/error}}"})
public class ErrorsHandler implements ErrorController {

    @Value("${server.error.path:${error.path:/error}}")
    private String errorPath;

    @Override
    public String getErrorPath() {
        return errorPath;
    }

    @RequestMapping(produces = "application/json")
    @ResponseBody
    public Object error(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (Objects.equals(HttpStatus.INTERNAL_SERVER_ERROR.value(), statusCode)) {
            //代码异常或运行时异常 的服务端错误  （会打印异常）
            return Result.fail(Code.C500, null);
        }else {
            //400 未捕获的参数错误 、 404 路径未找到 、 405 动词不允许 的客户端错误 （不会打印异常）
            return Result.fail(statusCode, null);
        }
    }

    @ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
    @RequestMapping(produces = {"text/html"})
    public ModelAndView errorHtml(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        return mav;
    }

}
