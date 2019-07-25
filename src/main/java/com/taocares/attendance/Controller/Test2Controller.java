package com.taocares.attendance.Controller;

import com.alibaba.dingtalk.openapi.demo.OApiException;
import com.alibaba.dingtalk.openapi.demo.auth.AuthHelper;
import com.alibaba.dingtalk.openapi.demo.department.DepartmentHelper;
import com.dingtalk.open.client.api.model.corp.Department;
import com.dingtalk.open.client.common.SdkInitException;
import com.dingtalk.open.client.common.ServiceException;
import com.dingtalk.open.client.common.ServiceNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

import static com.alibaba.dingtalk.openapi.demo.department.DepartmentHelper.listDepartments;

/**
 * @author LFX
 * @DESCRIPTION
 * @create
 */

@Controller
public class Test2Controller {

    @GetMapping(value = "/test2")
    public String test2(Map<String,Object> map, HttpSession session){
        map.put("userid",session.getAttribute("userid"));
        return "jump";
    }
}
