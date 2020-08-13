package com.bwx.service;

import com.bwx.Entity.DO.ClassifyDO;

import java.util.List;

/**
 * @Author BiWeixiao
 * @Date Created in 13:20 20/4/16
 */

public interface IClassifyService {
    ClassifyDO selectOneParent(String parentId);

    List<ClassifyDO> selectParent();

    List<ClassifyDO> selectByParentId(String parentId);

    void insert(ClassifyDO classifyDO);
}
