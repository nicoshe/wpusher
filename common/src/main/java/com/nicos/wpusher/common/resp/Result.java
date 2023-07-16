package com.nicos.wpusher.common.resp;

public class Result<T> {

    private final static int SUCCESS = 200;

    private int code;

    private String error;

    private T data;

    public static <T> Result<T> success() {
        return success(null);
    }

    public static <T> Result<T> success(T t) {
        Result<T> result = new Result<>();
        result.data = t;
        result.code = SUCCESS;
        return result;
    }

    public static <T> Result<T> failed(int code, String error) {
        Result<T> result = new Result<>();
        result.data = null;
        result.code = code;
        result.error = error;
        return result;
    }
}
