package com.bwx.service;

import com.bwx.Entity.DO.BannerDO;

import java.util.List;

/**
 * @Author BiWeixiao
 * @Date Created in 17:31 20/4/14
 */

public interface IBannerService {
    List<BannerDO> selectAllBanner();

    List<BannerDO> selectBanner1();

    BannerDO selectBanner2();

    List<BannerDO> selectBanner0();
}
