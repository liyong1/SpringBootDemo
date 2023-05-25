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

    // 1、语法： 请求路径：/cars/sell;low=34;brand=byd,audi,yd
    // 2、SpringBoot默认禁用了矩阵变量的功能
    //      手动开启：原理。对于路径的处理。UrlPathHelper进行解析。
    //      removeSemicolonContent（移除分号内容）支持矩阵变量
    //3、矩阵变量必须有url路径变量才能被解析
    @GetMapping("/cars/{path}")
    public Map carsSell(@MatrixVariable("low") Integer low,
                        @MatrixVariable("brand") List<String> brands,
                        @PathVariable("path") String path) {
        Map<String, Object> map = new HashMap();
        map.put("low",low);
        map.put("brand",brands);
        map.put("path",path);
        return map;
    }

    // /boss/1;age=14/2;age=16
    @GetMapping("/boss/{bossId}/{empId}")
    public Map boss(@MatrixVariable(value = "age",pathVar = "bossId") String bossAge,
                    @MatrixVariable(value = "age", pathVar = "empId") String empAge,
                    @PathVariable("bossId") String bossId,
                    @PathVariable("empId") String empId) {
        Map<String, Object> map = new HashMap<>();
        map.put("bossAge",bossAge);
        map.put("empAge", empAge);
        map.put("bossId", bossId);
        map.put("empId", empId);
        return map;

    }
}
