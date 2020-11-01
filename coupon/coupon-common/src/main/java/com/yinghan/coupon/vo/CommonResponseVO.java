package com.yinghan.coupon.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponseVO<T> implements Serializable {
    private Integer code;
    private String message;
    private T data;

    public CommonResponseVO(int code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }
}
