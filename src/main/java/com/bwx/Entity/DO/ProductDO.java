package com.bwx.Entity.DO;

import java.util.Date;

public class ProductDO {
    private String productId;

    private String productName;

    private String productDescription;

    private Double productPrice;

    private String productAddress;

    private Integer mainImageNum;

    private Integer detailImageNum;

    private Date lastUpdateTime;

    private String userId;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription == null ? null : productDescription.trim();
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
        this.productAddress = productAddress == null ? null : productAddress.trim();
    }

    public Integer getMainImageNum() {
        return mainImageNum;
    }

    public void setMainImageNum(Integer mainImageNum) {
        this.mainImageNum = mainImageNum;
    }

    public Integer getDetailImageNum() {
        return detailImageNum;
    }

    public void setDetailImageNum(Integer detailImageNum) {
        this.detailImageNum = detailImageNum;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ProductDO other = (ProductDO) that;
        return (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
                && (this.getProductName() == null ? other.getProductName() == null : this.getProductName().equals(other.getProductName()))
                && (this.getProductDescription() == null ? other.getProductDescription() == null : this.getProductDescription().equals(other.getProductDescription()))
                && (this.getProductPrice() == null ? other.getProductPrice() == null : this.getProductPrice().equals(other.getProductPrice()))
                && (this.getProductAddress() == null ? other.getProductAddress() == null : this.getProductAddress().equals(other.getProductAddress()))
                && (this.getMainImageNum() == null ? other.getMainImageNum() == null : this.getMainImageNum().equals(other.getMainImageNum()))
                && (this.getDetailImageNum() == null ? other.getDetailImageNum() == null : this.getDetailImageNum().equals(other.getDetailImageNum()))
                && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
                && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
        result = prime * result + ((getProductDescription() == null) ? 0 : getProductDescription().hashCode());
        result = prime * result + ((getProductPrice() == null) ? 0 : getProductPrice().hashCode());
        result = prime * result + ((getProductAddress() == null) ? 0 : getProductAddress().hashCode());
        result = prime * result + ((getMainImageNum() == null) ? 0 : getMainImageNum().hashCode());
        result = prime * result + ((getDetailImageNum() == null) ? 0 : getDetailImageNum().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        return result;
    }
}