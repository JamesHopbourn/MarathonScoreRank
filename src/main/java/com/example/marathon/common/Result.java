package com.example.marathon.common;

import lombok.Data;

@Data
public class Result {
    private final int code;
    private final String message;
    private final Object data;
    public static final Result OK = new Result(0, null, null);

    protected Result() {
        code = 0;
        message = null;
        data = null;
    }

    protected Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result ok(Object data) {
        return new Result(0, null, data);
    }

}
