package com.bwx.mapper;

import com.bwx.Entity.DO.PastureDO;

import java.util.List;

public interface PastureDOMapper {
    int deleteByPrimaryKey(PastureDO key);

    int insert(PastureDO record);

    int insertSelective(PastureDO record);

    PastureDO selectByPrimaryKey(PastureDO key);

    int updateByPrimaryKeySelective(PastureDO record);

    int updateByPrimaryKey(PastureDO record);

    List<PastureDO> selectAll();

    PastureDO selectById(String pastureId);
}