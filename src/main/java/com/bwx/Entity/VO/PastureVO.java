package com.bwx.Entity.VO;

import java.util.List;

/**
 * @Author BiWeixiao
 * @Date Created in 13:03 20/4/15
 */

public class PastureVO {
    private String pastureId;

    private String pastureName;

    private String pastureDescription;

    private int likeNum;

    private String pastureAddress;

    private List<String> mainImages;

    private List<String> detailImages;

    private String userId;

    private int upNum;

    private boolean ifCollect;

    public String getPastureId() {
        return pastureId;
    }

    public void setPastureId(String pastureId) {
        this.pastureId = pastureId;
    }

    public String getPastureName() {
        return pastureName;
    }

    public void setPastureName(String pastureName) {
        this.pastureName = pastureName;
    }

    public String getPastureDescription() {
        return pastureDescription;
    }

    public void setPastureDescription(String pastureDescription) {
        this.pastureDescription = pastureDescription;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public String getPastureAddress() {
        return pastureAddress;
    }

    public void setPastureAddress(String pastureAddress) {
        this.pastureAddress = pastureAddress;
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

    public boolean isIfUp() {
        return ifUp;
    }

    public void setIfUp(boolean ifUp) {
        this.ifUp = ifUp;
    }

    private boolean ifUp;


}
