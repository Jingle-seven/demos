package xz.model;

public class AssetOwner extends BaseRecord{

    private Long assetNumber;

    private String owner;

    private String acquire;

    private String aquireTime;

    private String status;


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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}