package com.bwx.common;

/**
 * @author BiWeixiao
 * @time 2019-11-12 17:49
 */
public enum ResponseCode {
    SUCCESS(0, "SUCCESS"),
    ERROR(1, "ERROE"),
    NEED_LOGIN(10, "NEED_LOGIN"),
    ILLEGAL_ARGUMENTS(1, "ILLEGAL_ARGUMENTS");
    private final int code;
    private final String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
