package com.alibaba.dingtalk.openapi.demo.later;

import com.alibaba.dingtalk.openapi.demo.auth.AuthHelper;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiAttendanceGetleaveapprovedurationRequest;
import com.dingtalk.api.request.OapiAttendanceGetleavestatusRequest;
import com.dingtalk.api.response.OapiAttendanceGetleaveapprovedurationResponse;
import com.dingtalk.api.response.OapiAttendanceGetleavestatusResponse;
import com.taobao.api.ApiException;
import com.taobao.api.internal.util.StringUtils;

/**
 * @Description 查询考勤相关
 * @Author thf
 * @Date 2019-07-25
 **/
public class LaterHelper {


    /**
     * @Author thf
     * @Description 获取某用户某段时间考勤数据
     * @Param [accessToken, userForDay]
     * @Return java.lang.String
     **/
    public static String getUserLaterDay(String accessToken, UserForDay userForDay) throws Exception {
        if(userForDay == null ||
            userForDay.getStartTime() == null ||
            userForDay.getEndTime() == null ||
            (userForDay.getEndTime() < userForDay.getStartTime()) ||
            (userForDay.getEndTime() - userForDay.getStartTime() > 15552000000L)){
            throw new Exception("数据输入异常。");
        }
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/attendance/getleavestatus");
        OapiAttendanceGetleavestatusRequest req = new OapiAttendanceGetleavestatusRequest();
        req.setUseridList(userForDay.getUserId());
        req.setStartTime(userForDay.getStartTime());
        req.setEndTime(userForDay.getEndTime());
        req.setOffset(userForDay.getOffset());
        req.setSize(userForDay.getSize());
        OapiAttendanceGetleavestatusResponse rsp = null;
        try {
            rsp = client.execute(req, accessToken);
        } catch (ApiException e) {
            System.err.println(e.getErrMsg());
        }
        return rsp == null? "":rsp.getBody();
    }

    /**
     * @Author thf
     * @Description 获取某用户段时间内请假时长
     * @Param [accessToken, userForMinute]
     * @Return java.lang.String
     **/
    public static String getUserLaterMinute(String accessToken, UserForMinute userForMinute){

        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/attendance/getleaveapproveduration");
        OapiAttendanceGetleaveapprovedurationRequest request = new OapiAttendanceGetleaveapprovedurationRequest();
        request.setFromDate(userForMinute.getStartTime());
        request.setToDate(userForMinute.getEndTime());
        request.setUserid(userForMinute.getUserId());
        OapiAttendanceGetleaveapprovedurationResponse response = null;
        try {
            response = client.execute(request,accessToken);
        } catch (ApiException e) {
            System.err.println(e.getErrMsg());
        }
        return response == null? "" : response.getBody();
    }
}
