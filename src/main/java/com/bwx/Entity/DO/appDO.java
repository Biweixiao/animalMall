package com.bwx.Entity.DO;

public class appDO {
    private String appid;

    private String secret;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret == null ? null : secret.trim();
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
        appDO other = (appDO) that;
        return (this.getAppid() == null ? other.getAppid() == null : this.getAppid().equals(other.getAppid()))
                && (this.getSecret() == null ? other.getSecret() == null : this.getSecret().equals(other.getSecret()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAppid() == null) ? 0 : getAppid().hashCode());
        result = prime * result + ((getSecret() == null) ? 0 : getSecret().hashCode());
        return result;
    }
}