package com.example.fzp.filter;



import com.example.fzp.exception.TokenAuthExpiredException;
import com.example.fzp.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.el.parser.TokenMgrError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@Slf4j
@Component
public class AuthHandlerInterceptor implements HandlerInterceptor {
    @Autowired
    TokenUtil tokenUtil;
    @Value("${token.privateKey}")
    private String privateKey;
    @Value("${token.yangToken}")
    private Long yangToken;
    @Value("${token.oldToken}")
    private Long oldToken;
    /**
     * 权限认证的拦截操作.
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        log.info("=======进入拦截器========");
        // 如果不是映射到方法直接通过,可以访问资源.
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        //为空就返回错误
        String token = httpServletRequest.getHeader("X-token");
        log.info("==============获取的token:" + token);
        if (null == token || "".equals(token.trim())) {
            log.info("token为空啦");
            throw new TokenAuthExpiredException();
//            return false;

        }
        log.info("==============token:" + token);
        Map<String, String> map = tokenUtil.parseToken(token);
        String userId = map.get("userId");
        String userRole = map.get("userRole");
        long timeOfUse = System.currentTimeMillis() - Long.parseLong(map.get("timeStamp"));
        //1.判断 token 是否过期
        //年轻 token
        if (timeOfUse < yangToken) {
            log.info("年轻 token");
        }
        //老年 token 就刷新 token
        else if (timeOfUse >= yangToken && timeOfUse < oldToken) {
            httpServletResponse.setHeader("token",tokenUtil.getToken(userId,userRole));
        }
        //过期 token 就返回 token 无效.
        else {
            throw new TokenAuthExpiredException();
        }
        //2.角色匹配.
        if ("user".equals(userRole)) {
            log.info("========user账户============");
            return true;
        }
        if ("admin".equals(userRole)) {
            log.info("========admin账户============");
            return true;
        }
        return false;
    }


}
