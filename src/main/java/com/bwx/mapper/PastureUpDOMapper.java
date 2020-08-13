package com.bwx.mapper;

import com.bwx.Entity.DO.PastureUpDO;

import java.util.List;

public interface PastureUpDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PastureUpDO record);

    int insertSelective(PastureUpDO record);

    PastureUpDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PastureUpDO record);

    int updateByPrimaryKey(PastureUpDO record);

    List<PastureUpDO> selectUpById(String pastureId);
}