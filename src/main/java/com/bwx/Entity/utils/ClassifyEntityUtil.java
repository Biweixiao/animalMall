package com.bwx.Entity.utils;

import com.bwx.Entity.DO.ClassifyDO;
import com.bwx.Entity.VO.ClassifyParentVO;
import com.bwx.Entity.VO.ClassifyVO;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author BiWeixiao
 * @Date Created in 13:07 20/4/16
 */

public class ClassifyEntityUtil {

    public ClassifyParentVO changeDOToParentVO(ClassifyDO classifyDO) {
        ClassifyParentVO classifyParentVO = new ClassifyParentVO();
        classifyParentVO.setClassifyId(classifyDO.getClassifyId());
        classifyParentVO.setClassifyName(classifyDO.getClassifyName());
        classifyParentVO.setImgUrl(classifyDO.getImgUrl());
        classifyParentVO.setPrice(360.0);
        return classifyParentVO;
    }

    public List<ClassifyParentVO> changeDOToParentVOList(List<ClassifyDO> classifyDOList) {
        List<ClassifyParentVO> classifyParentVOList = new ArrayList<>(classifyDOList.size());
        for (int i = 0; i < classifyDOList.size(); i++) {
            ClassifyParentVO classifyParentVO = changeDOToParentVO(classifyDOList.get(i));
            classifyParentVOList.add(i, classifyParentVO);
        }
        return classifyParentVOList;
    }

    public List<ClassifyVO> changeDOtoClassifyVOList(List<ClassifyDO> classifyDOList) {
        List<ClassifyVO> classifyVOList = new ArrayList<>(classifyDOList.size());
        for (int i = 0; i < classifyDOList.size(); i++) {
            ClassifyVO classifyVO = new ClassifyVO();
            classifyVO.setClassifyId(classifyDOList.get(i).getClassifyId());
            classifyVO.setClassifyName(classifyDOList.get(i).getClassifyName());
            classifyVO.setImgUrl(classifyDOList.get(i).getImgUrl());
            classifyVO.setParentId(classifyDOList.get(i).getParentId());
            classifyVO.setPrice(360.0);
            classifyVOList.add(i, classifyVO);
        }
        return classifyVOList;
    }
}
