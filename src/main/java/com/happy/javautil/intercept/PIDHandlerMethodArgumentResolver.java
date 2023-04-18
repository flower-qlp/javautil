package com.happy.javautil.intercept;

import com.happy.javautil.annotation.PID;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.HandlerMapping;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author happy
 */
public class PIDHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    
    private Pattern pattern = Pattern.compile("[^1-9]*");
    
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        PID parameterAnnotation = methodParameter.getParameterAnnotation(PID.class);
        return null != parameterAnnotation && StringUtils.isNotBlank(parameterAnnotation.value());
    }
    
    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
            NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        Map<String, String> uriTemplateVars = (Map<String, String>) nativeWebRequest.getAttribute(
                HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE, RequestAttributes.SCOPE_REQUEST);
        String value = uriTemplateVars.get(methodParameter.getParameterName());
        Class<?> parameterType = methodParameter.getParameterType();
        if (parameterType == String.class) {
            return value;
        } else if (parameterType == Long.class) {
            return doClassType(value);
        }
        return value;
    }
    
    private Object doClassType(String value) {
        Matcher matcher = pattern.matcher(value);
        if (matcher.matches()) {
            return Long.valueOf(value);
        } else {
            String result = matcher.replaceAll("");
            return Long.valueOf(result);
        }
    }
    
}
