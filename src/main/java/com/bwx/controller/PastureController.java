package com.bwx.controller;

import com.bwx.Entity.DO.CollectPastureDO;
import com.bwx.Entity.DO.PastureDO;
import com.bwx.Entity.DO.PastureUpDO;
import com.bwx.Entity.VO.PastureMainInfoVO;
import com.bwx.Entity.VO.PastureVO;
import com.bwx.Entity.utils.PastureEntityUtil;
import com.bwx.service.IPastureService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author BiWeixiao
 * @Date Created in 20:43 20/4/17
 */
@Controller
@RequestMapping("/pasture")
public class PastureController {
    String url = "https://9686.fun/images/";
    @Autowired
    private IPastureService iPastureService;

    @RequestMapping("/getAll")
    @ResponseBody
    public List<PastureMainInfoVO> getAllPasture() {
        List<PastureDO> pastureDOList = iPastureService.selectAll();
        PastureEntityUtil pastureEntityUtil = new PastureEntityUtil();
        List<PastureMainInfoVO> pastureMainInfoVOList = pastureEntityUtil.changeDOToMainInfoVOList(pastureDOList);
        return pastureMainInfoVOList;
    }

    @RequestMapping("/getById")
    @ResponseBody
    public PastureVO getById(@Param("id") String id) {
        String userId = "18589700806";
        PastureDO pastureDO = iPastureService.selectById(id);
        PastureVO pastureVO = new PastureVO();
        pastureVO.setPastureId(pastureDO.getPastureId());
        pastureVO.setPastureName(pastureDO.getPastureName());
        pastureVO.setLikeNum(pastureDO.getLikeNum());
        pastureVO.setPastureAddress(pastureDO.getPastureAddress());
        pastureVO.setUserId(pastureDO.getUserId());
        pastureVO.setPastureDescription(pastureDO.getPastureDescription());
        //获取赞数量
        List<PastureUpDO> pastureUpDOList = iPastureService.selectUpById(id);
        pastureVO.setUpNum(pastureUpDOList.size());//赞数量
        //判断是否赞
        pastureVO.setIfUp(false);
        for (int i = 0; i < pastureUpDOList.size(); i++) {
            if (userId == pastureUpDOList.get(i).getUserId()) ;
            pastureVO.setIfUp(true);
        }
        //判断是否收藏
        pastureVO.setIfCollect(false);
        CollectPastureDO collectPastureDO = iPastureService.selectCollectByPUId(id, userId);
        if (collectPastureDO != null) {
            pastureVO.setIfCollect(true);
        }


        List<String> mainImages = new ArrayList<>(pastureDO.getMainImageNum());
        for (int i = 0; i < pastureDO.getMainImageNum(); i++) {
            String imgUrl = url + pastureDO.getPastureId() + "_m_" + (i + 1) + ".png";
            mainImages.add(i, imgUrl);
        }
        pastureVO.setMainImages(mainImages);

        List<String> detailImages = new ArrayList<>(pastureDO.getDetailImageNum());
        for (int i = 0; i < pastureDO.getDetailImageNum(); i++) {
            detailImages.add(i, url + pastureDO.getPastureId() + "_d_" + (i + 1) + ".png");
        }
        pastureVO.setDetailImages(detailImages);

        return pastureVO;
    }
}
