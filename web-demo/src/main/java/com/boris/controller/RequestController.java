package com.boris.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liyong
 * RequestAttribute参数测试案例
 */
@Controller
public class RequestController {

    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request) {
        request.setAttribute("code",  200);
        request.setAttribute("msg", "成功了。。。");
        //转发到/success
        return "forward:/success";
    }

    @ResponseBody
    @GetMapping("/success")
    public Map success(@RequestAttribute("code") Integer code,
                       @RequestAttribute("msg") String msg,
                       HttpServletRequest request) {
        Object msg1 = request.getAttribute("msg");

        Map<String,Object> map = new HashMap<>();
        map.put("reqMethod", msg1);
        map.put("annotation_msg", msg);
        map.put("code", code);
        return map;
    }
}
