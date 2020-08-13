package com.bwx.Entity.DO;

public class OrderInfoDO {
    private Integer id;

    private String bid;

    private String sid;

    private String pid;

    private Integer ifBok;

    private Integer ifSok;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid == null ? null : bid.trim();
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public Integer getIfBok() {
        return ifBok;
    }

    public void setIfBok(Integer ifBok) {
        this.ifBok = ifBok;
    }

    public Integer getIfSok() {
        return ifSok;
    }

    public void setIfSok(Integer ifSok) {
        this.ifSok = ifSok;
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
        OrderInfoDO other = (OrderInfoDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getBid() == null ? other.getBid() == null : this.getBid().equals(other.getBid()))
                && (this.getSid() == null ? other.getSid() == null : this.getSid().equals(other.getSid()))
                && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
                && (this.getIfBok() == null ? other.getIfBok() == null : this.getIfBok().equals(other.getIfBok()))
                && (this.getIfSok() == null ? other.getIfSok() == null : this.getIfSok().equals(other.getIfSok()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBid() == null) ? 0 : getBid().hashCode());
        result = prime * result + ((getSid() == null) ? 0 : getSid().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getIfBok() == null) ? 0 : getIfBok().hashCode());
        result = prime * result + ((getIfSok() == null) ? 0 : getIfSok().hashCode());
        return result;
    }
}