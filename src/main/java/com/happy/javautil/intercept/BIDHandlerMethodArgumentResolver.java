package com.happy.javautil.intercept;

import com.happy.javautil.annotation.BID;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author zs
 */
public class BIDHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    
    
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.hasMethodAnnotation(BID.class);
    }
    
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        
        
        return null;
    }
}
