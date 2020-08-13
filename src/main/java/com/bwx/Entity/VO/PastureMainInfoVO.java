package com.bwx.Entity.VO;

/**
 * @Author BiWeixiao
 * @Date Created in 20:56 20/4/17
 */

public class PastureMainInfoVO {
    private String pastureId;

    private String pastureName;

    private String mainImages;

    private int likeNum;

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


    public String getMainImages() {
        return mainImages;
    }

    public void setMainImages(String mainImages) {
        this.mainImages = mainImages;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }
}
