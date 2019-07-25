package com.alibaba.dingtalk.openapi.demo.later;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Description 获取某用户段时间内请假时间
 * @Author thf
 * @Date 2019-07-25
 **/
@Getter
@Setter
public class UserForMinute {

    private String userId;
    private Date startTime;
    private Date endTime;

}
