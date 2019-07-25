package com.taocares.dispatch.constant;


/**
 * 常量Enum
 *
 * @author qinkai
 * @date 2018/09/07
 */
public enum DispatchEnum {

    DISPATCH_LEAVE_ATTENDANCESTATE("假", "请假记录类型查询");


    private final String code;
    private final String value;

    private DispatchEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}