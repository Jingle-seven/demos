package gen.pojo;

public class AssetOwner {
    private Long id;

    private Long assetNumber;

    private String owner;

    private String acquire;

    private String aquireTime;

    private Long createTime;

    private Long updateTime;

    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAssetNumber() {
        return assetNumber;
    }

    public void setAssetNumber(Long assetNumber) {
        this.assetNumber = assetNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAcquire() {
        return acquire;
    }

    public void setAcquire(String acquire) {
        this.acquire = acquire;
    }

    public String getAquireTime() {
        return aquireTime;
    }

    public void setAquireTime(String aquireTime) {
        this.aquireTime = aquireTime;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}