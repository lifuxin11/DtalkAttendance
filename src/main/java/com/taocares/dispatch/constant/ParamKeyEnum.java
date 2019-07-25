package com.taocares.dispatch.constant;


/**
 * 参数Enum
 *
 * @author qinkai
 * @date 2018/09/07
 */
public enum ParamKeyEnum {

    PARAM_NAME("name", "查询参数name"),
    PARAM_PAGE("page", "分页请求参数page"),
    PARAM_ID("id", "查询参数id"),
    PARAM_START_DATE("startDate","开始日期"),
    PARAM_END_DATE("endDate","结束日期"),
    PARAM_LIMIT("limit", "分页请求参数limit");


    private final String code;
    private final String value;

    private ParamKeyEnum(String code, String value) {
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