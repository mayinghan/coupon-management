package com.yinghan.coupon.advice;

import com.yinghan.coupon.annotation.IgnoreResponseAdvice;
import com.yinghan.coupon.vo.CommonResponseVO;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {

    @Override
    @SuppressWarnings("all")
    public boolean supports(MethodParameter method, Class<? extends HttpMessageConverter<?>> converterType) {
        // if the method or class is annotated with @IgnoreResponseAdvice, then no need to process the response body
        if(method.getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class)
                || method.getMethod().isAnnotationPresent(IgnoreResponseAdvice.class)) return false;

        return true; // go to beforeBodyWrite()
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter method,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {

        CommonResponseVO<Object> res = new CommonResponseVO<>(0, "");

        if(body == null) {
            return res;
        } else if (body instanceof CommonResponseVO) {
            res = (CommonResponseVO<Object>)body;
        } else {
            res.setData(body);
        }

        return res;
    }
}
