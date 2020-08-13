package com.bwx.mapper;

import com.bwx.Entity.DO.ClassifyDO;

import java.util.List;

public interface ClassifyDOMapper {
    int deleteByPrimaryKey(String classifyId);

    int insert(ClassifyDO record);

    int insertSelective(ClassifyDO record);

    ClassifyDO selectByPrimaryKey(String classifyId);

    int updateByPrimaryKeySelective(ClassifyDO record);

    int updateByPrimaryKey(ClassifyDO record);

    List<ClassifyDO> selectParent();

    List<ClassifyDO> selectByParentId(String parentId);

    ClassifyDO selectOneParent(String parentId);
}