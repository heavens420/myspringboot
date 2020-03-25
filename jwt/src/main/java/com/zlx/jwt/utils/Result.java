package com.zlx.jwt.utils;

import lombok.Data;

@Data
public class Result {
    private Boolean SUCCESS;
    private  String CODE;
    private  Object data;

    public Result() {
    }

    public Result(Boolean SUCCESS, String CODE) {
        this.SUCCESS = SUCCESS;
        this.CODE = CODE;
    }

    public Result(Boolean SUCCESS, String CODE, Object data) {
        this.SUCCESS = SUCCESS;
        this.CODE = CODE;
        this.data = data;
    }
}
