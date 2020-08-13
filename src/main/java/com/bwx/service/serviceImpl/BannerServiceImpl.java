package com.bwx.service.serviceImpl;

import com.bwx.Entity.DO.BannerDO;
import com.bwx.mapper.BannerDOMapper;
import com.bwx.service.IBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author BiWeixiao
 * @Date Created in 17:31 20/4/14
 */
@Service
public class BannerServiceImpl implements IBannerService {
    @Autowired
    private BannerDOMapper bannerDOMapper;

    @Override
    public List<BannerDO> selectAllBanner() {
        return bannerDOMapper.selectAllBanner();
    }

    @Override
    public List<BannerDO> selectBanner1() {
        return bannerDOMapper.selectBanner1();
    }

    @Override
    public BannerDO selectBanner2() {
        return bannerDOMapper.selectBanner2();
    }

    @Override
    public List<BannerDO> selectBanner0() {
        return bannerDOMapper.selectBanner0();
    }
}
