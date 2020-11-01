package com.yinghan.coupon.advice;

import com.yinghan.coupon.constant.ExceptionConstant;
import com.yinghan.coupon.exception.CouponException;
import com.yinghan.coupon.vo.CommonResponseVO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionAdvice {
    @ExceptionHandler(CouponException.class)
    public CommonResponseVO<String> couponExceptionHandler(HttpServletRequest req, CouponException ex) {
        CommonResponseVO<String> response = new CommonResponseVO<>(ExceptionConstant.CouponGenerateErr.code, ExceptionConstant.CouponGenerateErr.message);
        response.setData(ex.getMessage());
        return response;
    }
}
