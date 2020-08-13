package com.bwx.service.serviceImpl;

import com.bwx.Entity.DO.ClassifyDO;
import com.bwx.mapper.ClassifyDOMapper;
import com.bwx.service.IClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author BiWeixiao
 * @Date Created in 13:20 20/4/16
 */
@Service
public class ClassifyServiceImpl implements IClassifyService {
    @Autowired
    private ClassifyDOMapper classifyDOMapper;

    @Override
    public ClassifyDO selectOneParent(String parentId) {
        return classifyDOMapper.selectOneParent(parentId);
    }

    @Override
    public List<ClassifyDO> selectParent() {
        return classifyDOMapper.selectParent();
    }

    @Override
    public List<ClassifyDO> selectByParentId(String parentId) {
        return classifyDOMapper.selectByParentId(parentId);
    }

    @Override
    public void insert(ClassifyDO classifyDO) {
        classifyDOMapper.insert(classifyDO);
    }
}
