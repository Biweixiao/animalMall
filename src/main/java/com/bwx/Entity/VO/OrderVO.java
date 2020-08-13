package com.bwx.Entity.VO;

/**
 * @Author BiWeixiao
 * @Date Created in 13:08 20/4/24
 */

public class OrderVO {


    private int id;

    private String productId;

    private String productName;

    private Double productPrice;

    private String mainImages;

    private boolean ifOk;

    private String orderType;

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getMainImages() {
        return mainImages;
    }

    public void setMainImages(String mainImages) {
        this.mainImages = mainImages;
    }

    public boolean isIfOk() {
        return ifOk;
    }

    public void setIfOk(boolean ifOk) {
        this.ifOk = ifOk;
    }
}
