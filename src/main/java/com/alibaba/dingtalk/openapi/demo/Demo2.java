package com.alibaba.dingtalk.openapi.demo;

import com.alibaba.dingtalk.openapi.demo.auth.AuthHelper;
import com.alibaba.dingtalk.openapi.demo.department.DepartmentHelper;
import com.alibaba.dingtalk.openapi.demo.user.UserHelper;
import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiAttendanceGetleavestatusRequest;
import com.dingtalk.api.response.OapiAttendanceGetleavestatusResponse;
import com.dingtalk.open.client.api.model.corp.CorpUserList;
import com.dingtalk.open.client.api.model.corp.Department;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wellCh4n
 * @DESCRIPTION
 * @create 2017/11/15 10:46
 */
public class Demo2 {
    public static void main(String[] args) throws Exception{

//        List<Department> departmentList = new ArrayList<Department>();
//        departmentList = DepartmentHelper.listDepartments(AuthHelper.getAccessToken(),"1");
//        JSONObject usersJSON = new JSONObject();
//        System.out.println("depart num:" + departmentList.size());


//            // 获取部门成员
//            CorpUserList userList = UserHelper.getDepartmentUser(AuthHelper.getAccessToken(), 81629168, null, null, null);
//            List u = userList.getUserlist();
//            System.out.println("成功获取部门成员,部门成员user="+userList.getUserlist());

/*        DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/gettoken");
        OapiGettokenRequest request = new OapiGettokenRequest();
        request.setAppkey("dingq7u4z8b8v4oxrzyp");
        request.setAppsecret("E4R2_vkYfzpvMBvalimuD42t3g6-UCpvY3Qc48JQCOeKNQN1NJOP2dg3kQuSKOAK");
        request.setHttpMethod("GET");
        OapiGettokenResponse response = client.execute(request);*/

        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/attendance/getleavestatus");
        OapiAttendanceGetleavestatusRequest req = new OapiAttendanceGetleavestatusRequest();
        req.setUseridList("0202551016774953");
        req.setStartTime(1558770540000L);
        req.setEndTime(1564040940000L);
        req.setOffset(0L);
        req.setSize(20L);
        OapiAttendanceGetleavestatusResponse rsp = client.execute(req, AuthHelper.getAccessToken());
        System.out.println(rsp.getBody());

    }
}
