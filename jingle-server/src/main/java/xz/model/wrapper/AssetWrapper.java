package xz.model.wrapper;


import xz.model.Asset;
import xz.util.WrapperFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jinhua on 2017/6/16 11:44.
 */
public class AssetWrapper extends Asset {
	private String location;
	private String type;
	private String assetType;
	private String brand;
	private String user;
	private String owner;
	private String statusStr;
	private String cabinetNumber;
	private List<String> ips = new ArrayList<>();
	
	public String getCabinetNumber() {
		return cabinetNumber;
	}
	
	public AssetWrapper setCabinetNumber(String cabinetNumber) {
		this.cabinetNumber = cabinetNumber;
		return this;
	}
	
	public String getStatusStr() {
		return statusStr;
	}
	
	public AssetWrapper setStatusStr(String statusStr) {
		this.statusStr = statusStr;
		return this;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public AssetWrapper setOwner(String owner) {
		this.owner = owner;
		return this;
	}
	
	public String getType() {
		return type;
	}
	
	public AssetWrapper setType(String type) {
		this.type = type;
		return this;
	}
	
	public String getAssetType() {
		return assetType;
	}
	
	public AssetWrapper setAssetType(String assetType) {
		this.assetType = assetType;
		return this;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public AssetWrapper setBrand(String brand) {
		this.brand = brand;
		return this;
	}
	
	public String getUser() {
		return user;
	}
	
	public AssetWrapper setUser(String user) {
		this.user = user;
		return this;
	}
	
	public String getLocation() {
		return location;
	}
	
	public AssetWrapper setLocation(String location) {
		this.location = location;
		return this;
	}
	
	public List<String> getIps() {
		return ips;
	}
	
	public AssetWrapper setIps(List<String> ips) {
		this.ips = ips;
		return this;
	}
	public AssetWrapper addIp(String ip) {
		this.ips.add(ip);
		return this;
	}
	public static AssetWrapper castToWrapper(Asset as) {
		AssetWrapper asw =  new AssetWrapper();
		asw.setId(as.getId());
		asw.setSn(as.getSn());
		asw.setTypeId(as.getTypeId());
		asw.setInfo(as.getInfo());
		asw.setUserId(as.getUserId());
		asw.setModel(as.getModel());
		asw.setBrandId(as.getBrandId());
		asw.setOwnerId(as.getOwnerId());
		asw.setRemark(as.getRemark());
		asw.setStatus(as.getStatus());
		asw.setCabinetId(as.getCabinetId());
		asw.setCreateTime(as.getCreateTime());
		asw.setUpdateTime(as.getUpdateTime());
		return asw;
	}
	
	@Override
	public String toString() {
		return WrapperFactory.toStr(this);
	}
	
}
