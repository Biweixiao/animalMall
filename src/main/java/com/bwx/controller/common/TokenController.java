package com.bwx.controller.common;

import com.bwx.Entity.DO.UserDO;
import com.bwx.common.Const;
import com.bwx.service.IUserService;
import com.bwx.utils.JsonUtil;
import com.bwx.utils.RedisPoolUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;

/**
 * @Author BiWeixiao
 * @Date Created in 17:44 20/4/21
 */
@Controller
@RequestMapping("/token")
public class TokenController {
    String appId = "wxf1108a2cd56af5a3";
    String secret = "f2904f643c35d983cad1c061dfbcf8da";
    @Autowired
    private IUserService iUserService;

    @RequestMapping("/getToken")
    @ResponseBody
    public String getToken(@Param("code") String code, HttpSession session) {
        System.out.println("get token");
        String urlName = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appId + "&secret=" + secret + "&js_code=" + code + "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String openId;
        ResponseEntity<String> responseEntity = restTemplate.exchange(urlName, HttpMethod.GET, null, String.class);
        {

            String sessionData = responseEntity.getBody();
            String[] strings = sessionData.split(",");
            String index2 = strings[1].replace("\"openid\":\"", "");
            openId = index2.replace("\"}", "");

        }
        UserDO userDO = iUserService.selectByOpenId(openId);
        RedisPoolUtil.setEx(userDO.getUserTel(), openId, Const.RedisCacheTime.REDIS_SESSION_TIME);
        return userDO.getUserTel();
    }

    @RequestMapping("verify")
    @ResponseBody
    public boolean verifyToken(@Param("token") String token) {
        String result = RedisPoolUtil.get(token);
        if (result == null || result == "") {
            return false;
        }
        return true;
    }
}
