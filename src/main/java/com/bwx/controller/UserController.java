package com.bwx.controller;

import com.aliyuncs.exceptions.ClientException;
import com.bwx.Entity.DO.CollectDO;
import com.bwx.Entity.DO.OrderInfoDO;
import com.bwx.Entity.DO.ProductDO;
import com.bwx.Entity.DO.UserDO;
import com.bwx.Entity.VO.OrderVO;
import com.bwx.Entity.VO.ProductMainInfoVO;
import com.bwx.Entity.VO.UserVo;
import com.bwx.Entity.utils.ProductEntityUtil;
import com.bwx.service.IProductService;
import com.bwx.service.IUserService;
import com.bwx.utils.RedisPoolUtil;
import com.bwx.utils.SMSUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author BiWeixiao
 * @Date Created in 16:04 20/4/17
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;
    @Autowired
    private IProductService iProductService;

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public UserVo grtUserInfo(@Param("token") String token) {
        String openId = RedisPoolUtil.get(token);
        UserDO userDO = iUserService.selectByOpenId(openId);
        UserVo userVo = new UserVo();
        if (userDO != null) {
            userVo.setUserTel(userDO.getUserTel());
            userVo.setUserName(userDO.getUserName());
            userVo.setUserAddress(userDO.getUserAddress());
        }
        return userVo;
    }

    @RequestMapping("/getCollect")
    @ResponseBody
    public List<ProductMainInfoVO> getCollect(@Param("userId") String userId) {

        List<CollectDO> collectDOList = iUserService.selectCollect(userId);
        List<ProductMainInfoVO> productMainInfoVOList = new ArrayList<>();
        for (int i = 0; i < collectDOList.size(); i++) {
            ProductDO productDO = iProductService.selectById(collectDOList.get(i).getProductId());
            ProductEntityUtil productEntityUtil = new ProductEntityUtil();
            ProductMainInfoVO productMainInfoVO = productEntityUtil.changeDOToMainInfoVO(productDO);
            productMainInfoVOList.add(productMainInfoVO);
        }
        return productMainInfoVOList;
    }

    @RequestMapping("/getPublish")
    @ResponseBody
    public List<ProductMainInfoVO> getPublish(@Param("userId") String userId) {
        List<ProductDO> productDOList = iProductService.selectByUserId(userId);
        ProductEntityUtil productEntityUtil = new ProductEntityUtil();
        List<ProductMainInfoVO> productMainInfoVOList = productEntityUtil.changeDOToMainInfoVOList(productDOList);
        return productMainInfoVOList;
    }


    @RequestMapping("/getMyBy")
    @ResponseBody
    public List<OrderVO> getMyBy(@Param("userId") String userId) {
        List<OrderInfoDO> orderDOList = iProductService.selectOrderBy(userId);
        List<OrderVO> orderVOList = new ArrayList<>();
        ProductEntityUtil productEntityUtil = new ProductEntityUtil();
        for (int i = 0; i < orderDOList.size(); i++) {
            OrderVO orderVO = new OrderVO();
            ProductMainInfoVO productMainInfoVO = productEntityUtil.changeDOToMainInfoVO(iProductService.selectById(orderDOList.get(i).getPid()));
            orderVO.setMainImages(productMainInfoVO.getMainImages());
            orderVO.setProductId(productMainInfoVO.getProductId());
            orderVO.setProductName(productMainInfoVO.getProductName());
            orderVO.setProductPrice(productMainInfoVO.getProductPrice());
            orderVO.setId(orderDOList.get(i).getId());
            orderVO.setIfOk(orderDOList.get(i).getIfBok() == 1);
            orderVOList.add(orderVO);
        }
        return orderVOList;
    }

    @RequestMapping("/getMySell")
    @ResponseBody
    public List<OrderVO> getMySell(@Param("userId") String userId) {
        List<OrderInfoDO> orderDOList = iProductService.selectOrderSell(userId);
        List<OrderVO> orderVOList = new ArrayList<>();
        ProductEntityUtil productEntityUtil = new ProductEntityUtil();
        for (int i = 0; i < orderDOList.size(); i++) {
            OrderVO orderVO = new OrderVO();
            ProductMainInfoVO productMainInfoVO = productEntityUtil.changeDOToMainInfoVO(iProductService.selectById(orderDOList.get(i).getPid()));
            orderVO.setMainImages(productMainInfoVO.getMainImages());
            orderVO.setProductId(productMainInfoVO.getProductId());
            orderVO.setProductName(productMainInfoVO.getProductName());
            orderVO.setProductPrice(productMainInfoVO.getProductPrice());
            orderVO.setId(orderDOList.get(i).getId());
            orderVO.setIfOk(orderDOList.get(i).getIfSok() == 1);
            orderVOList.add(orderVO);
        }
        return orderVOList;
    }

    @RequestMapping("/setOrderOk")
    @ResponseBody
    public boolean setOrderOk(@Param("userId") String userId, @Param("productId") String productId) {
        OrderInfoDO orderInfoDO = iProductService.selectOrder(userId, productId);
        if (orderInfoDO != null) {
            orderInfoDO.setIfSok(1);
            orderInfoDO.setIfBok(1);
            iProductService.updateOrder(orderInfoDO);
            return true;
        }
        return false;
    }

    @RequestMapping("/setOrder")
    @ResponseBody
    public boolean setOrder(@Param("userId") String userId, @Param("productId") String productId) throws ClientException {

        ProductDO productDO = iProductService.selectById(productId);
        String tel = productDO.getUserId();
        SMSUtil smsUtil = new SMSUtil();
        smsUtil.sendSMS(tel, userId);
        OrderInfoDO orderInfoDO = new OrderInfoDO();
        orderInfoDO.setIfBok(0);
        orderInfoDO.setIfSok(0);
        orderInfoDO.setBid(userId);
        orderInfoDO.setSid(productDO.getUserId());
        orderInfoDO.setPid(productId);
        iProductService.setOrder(orderInfoDO);
        return false;
    }
}
