package xz.model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Jinhua on 2017/6/16 11:44.
 */
public class AssetWrapper extends Asset {
	private String location;
	private List<String> ips = new ArrayList<>();
	
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
		asw.setType(as.getType());
		asw.setInfo(as.getInfo());
		asw.setUser(as.getUser());
		asw.setModel(as.getModel());
		asw.setBrand(as.getBrand());
		asw.setOwner(as.getOwner());
		asw.setRemark(as.getRemark());
		asw.setStatus(as.getStatus());
		asw.setCabinetId(as.getCabinetId());
		asw.setCreateTime(as.getCreateTime());
		asw.setUpdateTime(as.getUpdateTime());
		return asw;
	}
	
	@Override
	public String toString() {
		List<Field> list = new ArrayList<>();
		Class<?> cls = super.getClass();
		
		Collections.addAll(list,cls.getSuperclass().getSuperclass().getDeclaredFields());
		Collections.addAll(list,cls.getSuperclass().getDeclaredFields());
		Collections.addAll(list,cls.getDeclaredFields());
		final StringBuilder sb = new StringBuilder("AssetWrapper{");
		for (Field f: list) {
			f.setAccessible(true);
			try {
				sb.append(f.getName()).append(":").append(f.get(this)).append(",");
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		sb.deleteCharAt(sb.lastIndexOf(","));
		sb.append('}');
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new AssetWrapper());
	}
}
