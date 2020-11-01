package com.yinghan.coupon.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum ValidityPeriod {
    FIX(0, "fixed date"),
    SHIFT(1, "start from the getting time");

    private Integer code;
    private String description;

    public static ValidityPeriod of(int code) {
        Objects.requireNonNull(code);
        return Stream.of(values())
                .filter(it -> it.code == code)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(code + " not exists"));
    }
}
