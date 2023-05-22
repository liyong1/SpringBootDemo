package com.boris.controller;

import com.boris.MainApplication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liyong
 */
@RestController
public class ParameterTestController {

    //  car/2/owner/zhangsan
    @GetMapping("/car/{id}/owner/{username}")
    public Map<String, Object> getCar(@PathVariable("id") String id,
                                      @PathVariable("username") String username,
                                      @PathVariable Map<String, String> pv,
                                      @RequestHeader("User-Agent") String user_Agent,
                                      @RequestHeader Map<String,String> rh,
                                      @RequestParam("age") String age,
                                      @RequestParam("inters")List<String> inters,
                                      @RequestParam Map<String, String> params)  {
        Map<String,Object> map = new HashMap<>();

//        map.put("id", id);
//        map.put("username", username);
//        map.put("pv", pv);
//        map.put("User-Agent", user_Agent);
//        map.put("rh", rh);

        map.put("age",age);
        map.put("inters",inters);
        map.put("params",params);
//        map.put("_ga",_ga);
//        System.out.println(cookie.getName()+"===>"+cookie.getValue());
        return map;
    }

    @PostMapping("/save")
    public Map postMethod(@RequestBody String content){
        Map<String,Object> map = new HashMap<>();
        map.put("content",content);
        return map;
    }
}
