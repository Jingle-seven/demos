package xz.model;

import xz.model.abst.BaseRecord;

public class WorkbenchAssignment extends BaseRecord {
    
    private Long tableId;
    
    private Long user;

    private Long startTime;

    private Long expiredTime;

    private String remark;
    
    public Long getTableId() {
        return tableId;
    }
    
    public WorkbenchAssignment setTableId(Long tableId) {
        this.tableId = tableId;
        return this;
    }
    
    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}