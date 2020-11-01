package com.yinghan.coupon.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum DistributeTarget {

    SINGLE(0, "single user, require manual pickup"),
    MULTI(1, "multi user, auto distribution");

    private Integer targetCode;
    private String description;

    public static DistributeTarget of(int code) {
        Objects.requireNonNull(code);
        return Stream.of(values())
                .filter(it -> it.targetCode == code)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(code + " not exists"));
    }
}
