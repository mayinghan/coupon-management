package com.yinghan.coupon.advice;

import com.yinghan.coupon.constant.ExceptionConstant;
import com.yinghan.coupon.exception.CouponException;
import com.yinghan.coupon.object.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionAdvice {
    @ExceptionHandler(CouponException.class)
    public CommonResponse<String> couponExceptionHandler(HttpServletRequest req, CouponException ex) {
        CommonResponse<String> response = new CommonResponse<>(ExceptionConstant.CouponGenerateErr.code, ExceptionConstant.CouponGenerateErr.message);
        response.setData(ex.getMessage());
        return response;
    }
}
