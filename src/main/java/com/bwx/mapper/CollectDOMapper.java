package com.bwx.mapper;

import com.bwx.Entity.DO.CollectDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CollectDO record);

    int insertSelective(CollectDO record);

    CollectDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CollectDO record);

    int updateByPrimaryKey(CollectDO record);

    List<CollectDO> selectByUserId(String userId);

    List<CollectDO> selectCollectByPId(String productId);

    boolean setCollectToFalse(@Param("productId") String productId, @Param("userId") String userId);

    void setCollectToTrue(CollectDO collectDO);

    CollectDO selectCollectByPUId(@Param("productId") String productId, @Param("userId") String userId);
}