package com.bwx.controller;

import com.bwx.Entity.DO.*;
import com.bwx.Entity.VO.ProductMainInfoVO;
import com.bwx.Entity.VO.ProductVO;
import com.bwx.Entity.utils.ProductEntityUtil;
import com.bwx.service.IClassifyService;
import com.bwx.service.IProductService;
import com.bwx.service.IUserService;
import com.bwx.utils.ContentReviewUtil;
import com.bwx.utils.RedisPoolUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author BiWeixiao
 * @Date Created in 14:42 20/4/15
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService iProductService;
    @Autowired
    private IUserService iUserService;
    @Autowired
    private IClassifyService iClassifyService;

    //获取所有产品的详细信息
    @RequestMapping("/getProduct")
    @ResponseBody
    public List<ProductVO> getAllProduct() {
        ProductEntityUtil productEntityUtil = new ProductEntityUtil();
        List<ProductDO> productDOList = iProductService.selectAllProduct();
        List<ProductVO> productVOList = productEntityUtil.changeDOToVOList(productDOList);
        return productVOList;
    }

    //根据Id获取某一个产品
    @RequestMapping("/getProductById")
    @ResponseBody
    public ProductVO getProductById(@Param("productId") String productId, @Param("userId") String userId) {
        userId = "18589700806";
        ProductDO productDO = iProductService.selectById(productId);
        List<CollectDO> collectDOList = iProductService.selectCollectByPId(productId);
        boolean ifCollect = false;
        for (int i = 0; i < collectDOList.size(); i++) {
            if (userId.equals(collectDOList.get(i).getUserId()))
                ifCollect = true;
        }
        List<ProductUpDO> productUpDOList = iProductService.selectUpById(productId);
        boolean ifUp = false;
        for (int i = 0; i < productUpDOList.size(); i++) {
            if (userId.equals(productUpDOList.get(i).getUserId()))
                ifUp = true;
        }
        boolean ifOrder = false;
        OrderInfoDO orderInfoDO = iProductService.selectUserOrder(userId, productId);
        if (orderInfoDO != null) {
            ifOrder = true;
        }
        ProductEntityUtil productEntityUtil = new ProductEntityUtil();
        ProductVO productVO = productEntityUtil.changeDOToVO(productDO);
        productVO.setIfCollect(ifCollect);
        productVO.setUpNum(collectDOList.size());
        productVO.setIfOrder(ifOrder);
        productVO.setIfUp(ifUp);
        return productVO;
    }

    //首页获取所有产品的主要信息
    @RequestMapping("/getProductMainInfo")
    @ResponseBody
    public List<ProductMainInfoVO> getProductMainInfo() {
        ProductEntityUtil productEntityUtil = new ProductEntityUtil();
        List<ProductDO> productDOList = iProductService.selectAllProduct();
        List<ProductMainInfoVO> productMainInfoVOList = productEntityUtil.changeDOToMainInfoVOList(productDOList);
        return productMainInfoVOList;
    }

    //取消赞
    @RequestMapping("/setCollectToFalse")
    @ResponseBody
    public void setCollectToFalse(@Param("productId") String productId) {
        String tel = "18589700806";
        iProductService.setCollectToFalse(productId, tel);
    }

    //用户删除
    @RequestMapping("/deletePublish")
    @ResponseBody
    public void deletePublish(@Param("tel") String tel, @Param("productId") String productId) {
        String openId = RedisPoolUtil.get(tel);
        System.out.println("openid:" + openId);

        UserDO userDO = iUserService.selectByOpenId(openId);
        if (userDO.getUserTel().equals(tel)) {
            iProductService.deleteByPId(productId);
        }
    }

    //赞
    @RequestMapping("/setCollectToTrue")
    @ResponseBody
    public void setCollectToTrue(@Param("productId") String productId) {
        String userId = "18589700806";
        System.out.println(productId);
        CollectDO collectDO = new CollectDO();
        collectDO.setProductId(productId);
        collectDO.setUserId(userId);
        Date date = new Date();

        collectDO.setLastUpdateTime(date);
        CollectDO collectDO1 = iProductService.selectCollectByPUId(productId, userId);
        if (collectDO1 == null) {
            System.out.println("插入赞记录！");
            iProductService.setCollectToTrue(collectDO);
        }
    }

    //获取一个上传uuid
    @RequestMapping("/getOneUUID")
    @ResponseBody
    public String getOneUUID(@Param("token") String token) {
        String openId = RedisPoolUtil.get(token);
        UserDO userDO = iUserService.selectByOpenId(openId);
        if (openId.equals(userDO.getOpenId())) {
            String uuid = UUID.randomUUID().toString();
            ProductDO productDO = new ProductDO();
            productDO.setProductId(uuid);
            productDO.setUserId(token);
            productDO.setDetailImageNum(0);
            productDO.setMainImageNum(0);
            productDO.setProductDescription("");
            productDO.setProductAddress(userDO.getUserAddress());
            productDO.setProductPrice(0.0);
            productDO.setProductName("");
            productDO.setLastUpdateTime(new Date());
            iProductService.insertProduct(productDO);
            return uuid;
        } else {
            return null;
        }
    }

    @RequestMapping("/publishProduct")
    @ResponseBody
    public boolean publishProduct(@Param("productName") String productName, @Param("productDescription") String productDescription, @Param("productPrice") String productPrice,
                                  @Param("classifyName") String classifyName, @Param("token") String token, @Param("uuid") String uuid) {

        ContentReviewUtil contentReviewUtil = new ContentReviewUtil();
        System.out.println(productName + "_______________" + productDescription);
        if (contentReviewUtil.checkWord(productName + "_______________" + productDescription)) {
            ProductDO productDO = iProductService.selectById(uuid);
            if (productDO != null && productDO.getUserId().equals(token)) {
                productDO.setProductName(productName);
                productDO.setProductDescription(productDescription);
                productDO.setProductPrice(Double.parseDouble(productPrice));
                ClassifyDO classifyDO = new ClassifyDO();
                classifyDO.setClassifyId(uuid);
                classifyDO.setClassifyName(productName);
                classifyDO.setParentId(String.valueOf(Integer.parseInt(classifyName) + 1));
                classifyDO.setLastUpdateTime(new Date());
                iClassifyService.insert(classifyDO);
                iProductService.update(productDO);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
