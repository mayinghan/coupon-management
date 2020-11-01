package com.yinghan.coupon.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum CouponCategory {
    CASHBACK_WITH_CONDITION(0, "cash back with condition"),
    DISCOUNT(1, "xxx off"),
    CASHBACK_WITHOUT_CONDITION(2, "cash back without condition");

    private Integer code;
    private String description;


    public static CouponCategory of(int code) {
        Objects.requireNonNull(code);
        return Stream.of(values())
                .filter(it -> it.code == code)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(code + " not exists"));
    }
}
