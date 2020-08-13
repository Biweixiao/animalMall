package com.bwx.Entity.VO;

import java.util.List;

/**
 * @Author BiWeixiao
 * @Date Created in 16:51 20/4/15
 */

public class ProductMainInfoVO {
    private String productId;

    private String productName;

    private Double productPrice;

    private String mainImages;

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
}
