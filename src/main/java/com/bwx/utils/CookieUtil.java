package com.bwx.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author BiWeixiao
 */
@Slf4j
public class CookieUtil {
    private final static String COOKIE_DOMAIN = PropertiesUtil.getProperty("cookie.domain");
    //登录用户的cookie
    private final static String LOGIN_COOKIE_NAME = "mmall_login_token";

    //读取用户cookie
    public static String readLoginToken(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                log.info("read cookieName{},cookieValue{}", cookie.getName(), cookie.getValue());
                if (StringUtils.equals(cookie.getName(), LOGIN_COOKIE_NAME)) {
                    log.info("return cookieName:{},cookieValue:{}", cookie.getName(), cookie.getValue());
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    //写登录cookie
    public static void writeLoginToken(HttpServletResponse response, String token) {
        Cookie cookie = new Cookie(LOGIN_COOKIE_NAME, token);
        cookie.setDomain(COOKIE_DOMAIN);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        //单位是秒，
        //如果这个maxAge不设置的话，cookie就不会写入硬盘，而是写在内存，只在当前页面有效
        cookie.setMaxAge(60 * 60 * 24 * 30);//如果是-1，代表永久
        log.info("write cookieName:{},cookieValue{}", cookie.getName(), cookie.getValue());
        response.addCookie(cookie);
    }

    //删除cookie，实际上是将cookie时间设置为0
    public static void delLoginToken(HttpServletResponse response, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (StringUtils.equals(cookie.getName(), LOGIN_COOKIE_NAME)) {
                    cookie.setDomain(COOKIE_DOMAIN);
                    cookie.setPath("/");
                    cookie.setMaxAge(0);
                    log.info("del cookieName{},cookieValue{}", cookie.getName(), cookie.getValue());
                    response.addCookie(cookie);
                }
            }
        }
    }
}
