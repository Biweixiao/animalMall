package com.bwx.Entity.utils;

import com.bwx.Entity.DO.ProductDO;
import com.bwx.Entity.VO.ProductMainInfoVO;
import com.bwx.Entity.VO.ProductVO;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author BiWeixiao
 * @Date Created in 13:07 20/4/15
 */

public class ProductEntityUtil {
    String url = "https://9686.fun/images/";

    public ProductVO changeDOToVO(ProductDO productDO) {
        ProductVO productVO = new ProductVO();
        productVO.setUserId(productDO.getUserId());
        productVO.setProductId(productDO.getProductId());
        productVO.setProductName(productDO.getProductName());
        productVO.setProductPrice(productDO.getProductPrice());
        productVO.setProductAddress(productDO.getProductAddress());
        productVO.setProductDescription(productDO.getProductDescription());

        List<String> mainImages = new ArrayList<>(productDO.getMainImageNum());
        for (int i = 0; i < productDO.getMainImageNum(); i++) {
            String imgUrl = url + productDO.getProductId() + "_m_" + (i + 1) + ".png";
            mainImages.add(i, imgUrl);
        }
        productVO.setMainImages(mainImages);

        List<String> detailImages = new ArrayList<>(productDO.getDetailImageNum());
        for (int i = 0; i < productDO.getDetailImageNum(); i++) {
            detailImages.add(i, url + productDO.getProductId() + "_d_" + (i + 1) + ".png");
        }
        productVO.setDetailImages(detailImages);
        return productVO;
    }

    public List<ProductVO> changeDOToVOList(List<ProductDO> productDOList) {
        List<ProductVO> productVOList = new ArrayList<>(productDOList.size());
        for (int i = 0; i < productDOList.size(); i++) {
            productVOList.add(i, changeDOToVO(productDOList.get(i)));
        }
        return productVOList;
    }

    public ProductMainInfoVO changeDOToMainInfoVO(ProductDO productDO) {
        ProductMainInfoVO productMainInfoVO = new ProductMainInfoVO();
        productMainInfoVO.setProductName(productDO.getProductName());
        productMainInfoVO.setProductId(productDO.getProductId());
        productMainInfoVO.setProductPrice(productDO.getProductPrice());
        productMainInfoVO.setMainImages(url + productDO.getProductId() + "_m_" + 1 + ".png");
        return productMainInfoVO;
    }

    public List<ProductMainInfoVO> changeDOToMainInfoVOList(List<ProductDO> productDOList) {
        List<ProductMainInfoVO> productMainInfoVOList = new ArrayList<>();
        for (int i = 0; i < productDOList.size(); i++) {
            if (productDOList.get(i).getProductPrice() != 0) {
                productMainInfoVOList.add(changeDOToMainInfoVO(productDOList.get(i)));
            }
        }
        return productMainInfoVOList;
    }
}
