package com.bwx.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

import java.util.Random;

/**
 * @Author BiWeixiao
 * @Date Created in 17:16 20/4/30
 */

public class SMSUtil {
    private static final String product = "Dysmsapi";
    private static final String domain = "dysmsapi.aliyuncs.com";
    private static final String accessKeyId = "LTAI4GDkbez2xvxpxbfVdHBU";
    private static final String getAccessKeySecret = "tnhO4Nzrd9QmDKOPIvYHwWKIal5gjI";

    public void sendSMS(String tel, String sTel) throws ClientException {
        /*将opt验证码通过短信验证发送给用户*/
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, getAccessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();
        /* 必填:待发送手机号 */
        request.setPhoneNumbers(tel);
        /* 必填:短信签名-可在短信控制台中找到 */
        request.setSignName("牛仔网");
        /* 必填:短信模板code-可在短信控制台中找到 */
        request.setTemplateCode("SMS_189460014");
        /* 可选:模板中的变量替换JSON串,如模板内容为"亲爱的用户,您的验证码为${code}"时,此处的值为 */
        request.setTemplateParam("{\"code\":\"" + sTel + "\"}");
        // hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            System.out.println("短信发送成功！验证码：" + sTel);
        } else {
            System.out.println("短信发送失败！");
        }
    }
}
