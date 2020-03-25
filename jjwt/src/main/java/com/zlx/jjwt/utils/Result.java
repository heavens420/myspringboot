package com.zlx.jjwt.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result {
    private int code;
    private String message;
    private boolean success;
    private Object object;

    public Result(int code, String message, boolean success, Object object) {
        this.code = code;
        this.message = message;
        this.success = success;
        this.object = object;
    }

    public Result(int code, Object object) {
        this.code = code;
        this.object = object;
    }

    public Result() {
    }
}
