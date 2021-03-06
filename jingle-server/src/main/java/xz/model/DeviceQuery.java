package xz.model;


import xz.util.XKit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Jinhua on 2017/6/14 10:31.
 */
public class DeviceQuery {
	private Long id;
	private Long sn;
	private Long number;
	private Long expiredTime;
	private String ip;
	private String owner;
	private String user;
	private String type;
	private String status;
	private String assetType;
	private String cabinetId;
	
	public Long getExpiredTime() {
		return expiredTime;
	}
	
	public DeviceQuery setExpiredTime(Long expiredTime) {
		this.expiredTime = expiredTime;
		return this;
	}
	
	public String getStatus() {
		return status;
	}
	
	public DeviceQuery setStatus(String status) {
		this.status = status;
		return this;
	}
	
	public String getAssetType() {
		return assetType;
	}
	
	public DeviceQuery setAssetType(String assetType) {
		this.assetType = assetType;
		return this;
	}
	
	public String getCabinetId() {
		return cabinetId;
	}
	
	public DeviceQuery setCabinetId(String cabinetId) {
		this.cabinetId = cabinetId;
		return this;
	}
	
	public String getUser() {
		return user;
	}
	
	public DeviceQuery setUser(String user) {
		this.user = user;
		return this;
	}
	
	public Long getNumber() {
		return number;
	}
	
	public DeviceQuery setNumber(Long number) {
		this.number = number;
		return this;
	}
	
	public Long getId() {
		return id;
	}
	
	public DeviceQuery setId(Long id) {
		this.id = id;
		return this;
	}
	
	public Long getSn() {
		return sn;
	}
	
	public DeviceQuery setSn(Long sn) {
		this.sn = sn;
		return this;
	}
	
	public String getIp() {
		return ip;
	}
	
	public DeviceQuery setIp(String ip) {
		this.ip = ip;
		return this;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public DeviceQuery setOwner(String owner) {
		this.owner = owner;
		return this;
	}
	
	public String getType() {
		return type;
	}
	
	public DeviceQuery setType(String type) {
		this.type = type;
		return this;
	}
	
	public String[] toMeta(){
		List<String> meta = new ArrayList<>();
		Map<String,Object> metaMap = XKit.castToMap(this);
		for(String k: metaMap.keySet()){
			meta.add(k+":"+metaMap.get(k));
		}
		return meta.toArray(new String [meta.size()]);
	}
	
	@Override
	public String toString() {
		return "{" +
				"id:" + id +
				", sn:" + sn +
				", number:" + number +
				", ip:'" + ip + '\'' +
				", owner:'" + owner + '\'' +
				", type:'" + type + '\'' +
				'}';
	}
}
