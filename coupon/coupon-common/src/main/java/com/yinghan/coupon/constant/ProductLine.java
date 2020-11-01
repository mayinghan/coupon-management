package com.yinghan.coupon.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum ProductLine {
    LINE_ONE(0, "line one"),
    LINE_TWO(1, "line two");

    private Integer code;
    private String description;

    public static ProductLine of(int code) {
        Objects.requireNonNull(code);
        return Stream.of(values())
                .filter(it -> it.code == code)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(code + " not exists"));
    }
}
