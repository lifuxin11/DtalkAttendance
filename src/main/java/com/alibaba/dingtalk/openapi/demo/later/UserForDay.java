package com.alibaba.dingtalk.openapi.demo.later;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description 获取某人段时间请假详情用
 * @Author thf
 * @Date 2019-07-25
 **/
@Getter
@Setter
public class UserForDay {

    private String userId;
    private Long startTime;
    private Long endTime;
    private Long offset = 0L;
    private Long size;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Long getOffset() {
        return offset;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        if(size > 20){
            this.size = 20L;
        }else{
            this.size = size;
        }
    }
}
