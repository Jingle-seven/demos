package xz.model;

/**
 * Created by Jinhua on 2017/5/4.
 */
public class TopoNode {
	String ip;
	String name;
	int times;
	String token;
	
	public TopoNode setIp(String ip) {
		this.ip = ip;
		if(name!=null)
			token = ip+name;
		return this;
	}
	
	public TopoNode setName(String name) {
		this.name = name;
		if(ip!=null)
			token = ip+name;
		return this;
	}
	
	public TopoNode setTimes(int times) {
		this.times = times;
		return this;
	}
	
	@Override
	public String toString() {
		return "TopoNode{" +
				"ip='" + ip + '\'' +
				", name='" + name + '\'' +
				", times=" + times +
				'}';
	}
}
