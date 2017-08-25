package xz.model;

import xz.model.abst.BaseRecord;

public class PoolNetwork extends BaseRecord {

    private String ip;

    private Long assetId;

    private Long userId;

    private Long startTime;

    private Long expiredTime;

    private Byte isExpired;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Long expiredTime) {
        this.expiredTime = expiredTime;
    }


    public Byte getIsExpired() {
        return isExpired;
    }

    public void setIsExpired(Byte isExpired) {
        this.isExpired = isExpired;
    }

}