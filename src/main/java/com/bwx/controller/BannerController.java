package com.bwx.controller;

import com.bwx.Entity.DO.BannerDO;
import com.bwx.service.IBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author BiWeixiao
 * @Date Created in 17:28 20/4/14
 */

@Controller
@RequestMapping(value = "/banner")
public class BannerController {
    @Autowired
    private IBannerService iBannerService;

    @RequestMapping("/getBanner")
    @ResponseBody
    public List<BannerDO> getBanner() {
        List<BannerDO> bannerDOList = iBannerService.selectBanner0();
        return bannerDOList;
    }

    @RequestMapping("/getBanner1")
    @ResponseBody
    public List<BannerDO> getBanner1() {
        List<BannerDO> bannerDOList = iBannerService.selectBanner1();
        return bannerDOList;
    }

    @RequestMapping("/getBanner2")
    @ResponseBody
    public BannerDO getBanner2() {
        BannerDO bannerDO = iBannerService.selectBanner2();
        return bannerDO;
    }
}
