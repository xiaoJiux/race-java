package com.example.fzp.controller;


import com.example.fzp.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jarvan
 * @version 1.0
 * @create 2021/2/11 0:10
 */
@RestController
public class TokenTestController {
    @Autowired
    TokenUtil tokenUtil;
    /**
     * 使用 /login 请求获得 token, /login 不经过拦截器
     */
    @RequestMapping("/login")
    public Map login(){

        Map map = new HashMap<>();
        Map map1= new HashMap<>();
        map1.put("token",tokenUtil.getToken("靓仔","admin"));
        map.put("code",20000);
        map.put("data",map1);
        return map;
    }
    /**
     * 使用 /test-token 测试 token，进过拦截器
     */
    @RequestMapping("/test-token")
    public Map testToken(HttpServletRequest request){
        String token = request.getHeader("X-token");
        return tokenUtil.parseToken(token);
    }

}