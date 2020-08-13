package com.bwx.Entity.VO;

import java.util.Date;
import java.util.List;

/**
 * @Author BiWeixiao
 * @Date Created in 13:03 20/4/15
 */

public class ProductVO {
    private String productId;

    private String productName;

    private String productDescription;

    private Double productPrice;

    private String productAddress;

    private List<String> mainImages;

    private List<String> detailImages;

    private String userId;

    private int upNum;

    private boolean ifUp;

    private boolean ifCollect;

    private boolean ifOrder;

    public boolean isIfOrder() {
        return ifOrder;
    }

    public void setIfOrder(boolean ifOrder) {
        this.ifOrder = ifOrder;
    }

    public boolean isIfUp() {
        return ifUp;
    }

    public void setIfUp(boolean ifUp) {
        this.ifUp = ifUp;
    }


    public int getUpNum() {
        return upNum;
    }

    public void setUpNum(int upNum) {
        this.upNum = upNum;
    }

    public boolean isIfCollect() {
        return ifCollect;
    }

    public void setIfCollect(boolean ifCollect) {
        this.ifCollect = ifCollect;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductAddress() {
        return productAddress;
    }

    public void setProductAddress(String productAddress) {
        this.productAddress = productAddress;
    }

    public List<String> getMainImages() {
        return mainImages;
    }

    public void setMainImages(List<String> mainImages) {
        this.mainImages = mainImages;
    }

    public List<String> getDetailImages() {
        return detailImages;
    }

    public void setDetailImages(List<String> detailImages) {
        this.detailImages = detailImages;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
