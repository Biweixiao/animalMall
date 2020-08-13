package com.bwx.mapper;

import com.bwx.Entity.DO.CollectPastureDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectPastureDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CollectPastureDO record);

    int insertSelective(CollectPastureDO record);

    CollectPastureDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CollectPastureDO record);

    int updateByPrimaryKey(CollectPastureDO record);

    CollectPastureDO selectCollectByPUId(@Param("pastureId") String pastureId, @Param("userId") String userId);
}