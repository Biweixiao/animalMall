package com.bwx.Entity.utils;

import com.bwx.Entity.DO.PastureDO;
import com.bwx.Entity.DO.ProductDO;
import com.bwx.Entity.VO.PastureMainInfoVO;
import com.bwx.Entity.VO.ProductMainInfoVO;
import com.bwx.Entity.VO.ProductVO;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author BiWeixiao
 * @Date Created in 13:07 20/4/15
 */

public class PastureEntityUtil {
    String url = "https://9686.fun/images/";

    public PastureMainInfoVO changeDOToMainInfoVO(PastureDO pastureDO) {
        PastureMainInfoVO pastureMainInfoVO = new PastureMainInfoVO();
        pastureMainInfoVO.setPastureId(pastureDO.getPastureId());
        pastureMainInfoVO.setPastureName(pastureDO.getPastureName());
        pastureMainInfoVO.setLikeNum(pastureDO.getLikeNum());
        pastureMainInfoVO.setMainImages(url + pastureDO.getPastureId() + "_m_" + 1 + ".png");
        return pastureMainInfoVO;
    }

    public List<PastureMainInfoVO> changeDOToMainInfoVOList(List<PastureDO> pastureDOList) {
        List<PastureMainInfoVO> pastureMainInfoVOList = new ArrayList<>(pastureDOList.size());
        for (int i = 0; i < pastureDOList.size(); i++) {
            pastureMainInfoVOList.add(i, changeDOToMainInfoVO(pastureDOList.get(i)));
        }
        return pastureMainInfoVOList;
    }
}
