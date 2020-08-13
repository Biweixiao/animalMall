package com.bwx.mapper;

import com.bwx.Entity.DO.appDO;

public interface appDOMapper {
    int deleteByPrimaryKey(String appid);

    int insert(appDO record);

    int insertSelective(appDO record);

    appDO selectByPrimaryKey(String appid);

    int updateByPrimaryKeySelective(appDO record);

    int updateByPrimaryKey(appDO record);
}