package com.yinghan.coupon.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionConstant {

    public static final class CouponGenerateErr {
        public static final String message = "Error - failed to general coupon";
        public static final int code = -1000;
    }
}
