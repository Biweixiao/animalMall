package com.bwx.controller;

import com.bwx.Entity.DO.ClassifyDO;
import com.bwx.Entity.DO.ProductDO;
import com.bwx.Entity.VO.ClassifyParentVO;
import com.bwx.Entity.VO.ClassifyVO;
import com.bwx.Entity.VO.ProductMainInfoVO;
import com.bwx.Entity.utils.Classify;
import com.bwx.Entity.utils.ClassifyEntityUtil;
import com.bwx.Entity.utils.ProductEntityUtil;
import com.bwx.service.IClassifyService;
import com.bwx.service.IProductService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author BiWeixiao
 * @Date Created in 12:34 20/4/16
 */
@Controller
@RequestMapping("/classify")
public class ClassifyController {
    @Autowired
    private IClassifyService iClassifyService;
    @Autowired
    private IProductService iProductService;

    //获取第一个父类
    @RequestMapping("/getAllParent")
    @ResponseBody
    public List<ClassifyParentVO> getAllParent() {
        List<ClassifyDO> classifyDOList = iClassifyService.selectParent();
        ClassifyEntityUtil classifyEntityUtil = new ClassifyEntityUtil();
        List<ClassifyParentVO> classifyParentVOList = classifyEntityUtil.changeDOToParentVOList(classifyDOList);
        return classifyParentVOList;
    }

    @RequestMapping("/getParent")
    @ResponseBody
    public ClassifyParentVO getParent(@Param("parentId") String parentId) {
        ClassifyDO classifyDO = iClassifyService.selectOneParent(parentId);
        ClassifyEntityUtil classifyEntityUtil = new ClassifyEntityUtil();
        List<ClassifyDO> classifyDOList = iClassifyService.selectByParentId(parentId);
        double price = 0;
        for (int i = 0; i < classifyDOList.size(); i++) {
            price += iProductService.selectById(classifyDOList.get(i).getClassifyId()).getProductPrice();
        }
        ClassifyParentVO classifyParentVO = classifyEntityUtil.changeDOToParentVO(classifyDO);
        classifyParentVO.setPrice((double) Math.round(price / classifyDOList.size()));
        return classifyParentVO;
    }

    //    //获取第二个父类
//    @RequestMapping("/getByParentId")
//    @ResponseBody
//    public List<ClassifyVO> getByParentId(@Param("parentId") String parentId){
//        List<ClassifyDO> classifyDOList=iClassifyService.selectByParentId(parentId);
//        ClassifyEntityUtil classifyEntityUtil=new ClassifyEntityUtil();
//        List<ClassifyVO> classifyVOList=classifyEntityUtil.changeDOtoClassifyVOList(classifyDOList);
//        return classifyVOList;
//    }
    //根据父类获取产品
    @RequestMapping("/getByParentId")
    @ResponseBody
    public List<ProductMainInfoVO> getByParentId(@Param("parentId") String parentId) {
        List<ClassifyDO> classifyDOList = iClassifyService.selectByParentId(parentId);
        List<ProductDO> productDOList = new ArrayList<>(classifyDOList.size());
        for (int i = 0; i < classifyDOList.size(); i++) {
            ProductDO productDO = iProductService.selectById(classifyDOList.get(i).getClassifyId());
            productDOList.add(i, productDO);
        }
        ProductEntityUtil productEntityUtil = new ProductEntityUtil();
        List<ProductMainInfoVO> productMainInfoVOList = productEntityUtil.changeDOToMainInfoVOList(productDOList);
        return productMainInfoVOList;
    }

    //获取分类
    @RequestMapping("/loadClassify")
    @ResponseBody
    public List<Classify> loadClassify() {
        List<ClassifyDO> classifyDOList = iClassifyService.selectParent();
        List<Classify> classifyList = new ArrayList<>(classifyDOList.size());
        for (int i = 0; i < classifyDOList.size(); i++) {
            Classify classify = new Classify();
            classify.setName(classifyDOList.get(i).getClassifyName());
            List<ClassifyDO> classifyDOList1 = iClassifyService.selectByParentId(classifyDOList.get(i).getClassifyId());
            String[] sonList = new String[classifyDOList1.size()];
            for (int j = 0; j < classifyDOList1.size(); j++) {
                sonList[j] = classifyDOList1.get(j).getClassifyName();
            }
            classify.setSon(sonList);
            classifyList.add(classify);
        }

        return classifyList;
    }
}
