package xz.model;

public class Asset extends BaseRecord{
    private String sn;

    private String number;

    private Long typeId;

    private Long assetTypeId;

    private Long brandId;

    private String model;

    private String info;

    private Long power;

    private String manageInfo;

    private String remark;

    private Long userId;

    private Long ownerId;

    private Long cabinetId;

    private Long startTime;

    private Long expiredTime;
    
    //设置默认值是为了在sqlProvider中不报错,
    private Byte isExpired = 0;
    
    public Byte getIsExpired() {
        return isExpired;
    }
    
    public Asset setIsExpired(Byte isExpired) {
        this.isExpired = isExpired;
        return this;
    }
    
    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getAssetTypeId() {
        return assetTypeId;
    }

    public void setAssetTypeId(Long assetTypeId) {
        this.assetTypeId = assetTypeId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public String getManageInfo() {
        return manageInfo;
    }

    public void setManageInfo(String manageInfo) {
        this.manageInfo = manageInfo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getCabinetId() {
        return cabinetId;
    }

    public void setCabinetId(Long cabinetId) {
        this.cabinetId = cabinetId;
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

}