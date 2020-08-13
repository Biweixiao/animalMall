package com.bwx.mapper;

import com.bwx.Entity.DO.BannerDO;

import java.util.List;

public interface BannerDOMapper {
    int deleteByPrimaryKey(Integer bannerId);

    int insert(BannerDO record);

    int insertSelective(BannerDO record);

    BannerDO selectByPrimaryKey(Integer bannerId);

    int updateByPrimaryKeySelective(BannerDO record);

    int updateByPrimaryKey(BannerDO record);

    List<BannerDO> selectAllBanner();

    List<BannerDO> selectBanner1();

    BannerDO selectBanner2();

    List<BannerDO> selectBanner0();
}