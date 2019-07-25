package com.taocares.attendance.Controller;

import com.alibaba.dingtalk.openapi.demo.auth.AuthHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author LFX
 * @DESCRIPTION
 */

@Controller
public class TestController {

    @GetMapping(value = "/test")
    public String helloHtml(Map<String,Object> map,HttpServletRequest request){
        map.put("config",AuthHelper.getConfig(request));

//        String config = AuthHelper.getConfig(request);
//        JSONObject obj = JSON.parseObject(config);
//        UserInfoServlet.login(obj.getString("agentid"),obj.getString("corpId"));

        map.put("test","testvalue");
        return "index";
    }
}
