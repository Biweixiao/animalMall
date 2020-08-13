package com.bwx.Entity.DO;

import java.util.Date;

public class PastureDO {
    private String pastureId;

    private String userId;

    private String pastureName;

    private String pastureAddress;

    private String pastureDescription;

    private Integer mainImageNum;

    private Integer detailImageNum;

    private Integer likeNum;

    private Date lastUpdateTime;

    public String getPastureId() {
        return pastureId;
    }

    public void setPastureId(String pastureId) {
        this.pastureId = pastureId == null ? null : pastureId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getPastureName() {
        return pastureName;
    }

    public void setPastureName(String pastureName) {
        this.pastureName = pastureName == null ? null : pastureName.trim();
    }

    public String getPastureAddress() {
        return pastureAddress;
    }

    public void setPastureAddress(String pastureAddress) {
        this.pastureAddress = pastureAddress == null ? null : pastureAddress.trim();
    }

    public String getPastureDescription() {
        return pastureDescription;
    }

    public void setPastureDescription(String pastureDescription) {
        this.pastureDescription = pastureDescription == null ? null : pastureDescription.trim();
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

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
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
        PastureDO other = (PastureDO) that;
        return (this.getPastureId() == null ? other.getPastureId() == null : this.getPastureId().equals(other.getPastureId()))
                && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
                && (this.getPastureName() == null ? other.getPastureName() == null : this.getPastureName().equals(other.getPastureName()))
                && (this.getPastureAddress() == null ? other.getPastureAddress() == null : this.getPastureAddress().equals(other.getPastureAddress()))
                && (this.getPastureDescription() == null ? other.getPastureDescription() == null : this.getPastureDescription().equals(other.getPastureDescription()))
                && (this.getMainImageNum() == null ? other.getMainImageNum() == null : this.getMainImageNum().equals(other.getMainImageNum()))
                && (this.getDetailImageNum() == null ? other.getDetailImageNum() == null : this.getDetailImageNum().equals(other.getDetailImageNum()))
                && (this.getLikeNum() == null ? other.getLikeNum() == null : this.getLikeNum().equals(other.getLikeNum()))
                && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPastureId() == null) ? 0 : getPastureId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getPastureName() == null) ? 0 : getPastureName().hashCode());
        result = prime * result + ((getPastureAddress() == null) ? 0 : getPastureAddress().hashCode());
        result = prime * result + ((getPastureDescription() == null) ? 0 : getPastureDescription().hashCode());
        result = prime * result + ((getMainImageNum() == null) ? 0 : getMainImageNum().hashCode());
        result = prime * result + ((getDetailImageNum() == null) ? 0 : getDetailImageNum().hashCode());
        result = prime * result + ((getLikeNum() == null) ? 0 : getLikeNum().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        return result;
    }
}