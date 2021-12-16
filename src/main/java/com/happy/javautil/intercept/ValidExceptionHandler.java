package com.happy.javautil.intercept;

import com.happy.javautil.entity.vo.RespVo;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author happy
 */
@ControllerAdvice
public class ValidExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public RespVo handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        List<FieldError> errors = bindingResult.getFieldErrors();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("errorMsg【");
        errors.forEach(fileError -> {
            stringBuffer.append(fileError.getField());
            stringBuffer.append(":");
            stringBuffer.append(fileError.getDefaultMessage());
            stringBuffer.append(" ");
        });
        stringBuffer.append("】");
        return new RespVo("6666", stringBuffer.toString(), null);
    }

}
