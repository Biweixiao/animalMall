package com.bwx.controller.common;


import com.bwx.Entity.DO.UserDO;
import com.bwx.common.Const;
import com.bwx.utils.CookieUtil;
import com.bwx.utils.JsonUtil;
import com.bwx.utils.RedisPoolUtil;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author:Biweixiao
 **/
@WebFilter
public class SessionExpireFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String loginToken = CookieUtil.readLoginToken(httpServletRequest);
        if (StringUtils.isNotEmpty(loginToken)) {
            UserDO user = JsonUtil.String2Obj(loginToken, UserDO.class);
            if (user != null) {
                RedisPoolUtil.expire(loginToken, Const.RedisCacheTime.REDIS_SESSION_TIME);
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
