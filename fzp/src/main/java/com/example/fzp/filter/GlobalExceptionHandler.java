package com.example.fzp.filter;



import com.example.fzp.exception.TokenAuthExpiredException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = TokenAuthExpiredException.class)
    @ResponseBody
    public Map tokenExpiredExceptionHandler(){
        log.warn("用户 token 过期");
        Map map = new HashMap();
        map.put("code",-1);
        map.put("message","用户token过期");
        return map;
    }


}
