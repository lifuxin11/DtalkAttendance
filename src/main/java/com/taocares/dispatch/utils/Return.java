package com.taocares.dispatch.utils;

/**
 * 返回数据
 *
 * @author qinkai
 * @date 2018/09/07
 */
public class Return {
    private Integer code;
    private String msg;
    private Integer count;
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Return error(String msg) {
        Return r = new Return();
        r.setCode(500);
        r.setMsg(msg);
        return r;
    }

    public static Return ok(String msg) {
        Return r = new Return();
        r.setCode(200);
        return r;
    }

    public static Return ok(Object data) {
        Return r = new Return();
        r.setCode(200);
        r.setData(data);
        return r;
    }

    public static Return ok(Integer count, Object data) {
        Return r = new Return();
        r.setCount(count);
        r.setCode(200);
        r.setData(data);
        return r;
    }

    public static Return ok() {
        Return r = new Return();
        r.setCode(200);
        return r;
    }

    public static Return error() {
        Return r = new Return();
        r.setCode(500);
        return r;
    }

}
