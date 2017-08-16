package xz.model;

/**
 * Created by Jinhua on 2017/6/9 17:31.
 */
public class BaseRecord {
	private Long createTime;
	private Long updateTime;
	private Long id;
	private String status;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
	
	public BaseRecord setStatus(String status) {
		this.status = status;
		return this;
	}
	
	@Override
	public String toString() {
		return "BaseRecord{" +
				"createTime=" + createTime +
				", updateTime=" + updateTime +
				", id=" + id +
				'}';
	}
}
