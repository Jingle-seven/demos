package xz.model;

/**
 * Created by Jinhua on 2017/5/4.
 */
public class TopoNode {
	private String ip;
	private String name;
	public String token;
	int times = 1;
	
	public TopoNode(String ip, String name) {
		this.ip = ip;
		this.name = name;
		genToken(ip, name);
	}
	
	private void genToken(String ip, String name) {
		this.token =  String.format("%s[%s]",name,ip);
	}
	
	public TopoNode setIp(String ip) {
		this.ip = ip;
		if(name!=null)
			genToken(ip, name);
		return this;
	}
	
	public TopoNode setName(String name) {
		this.name = name;
		if(ip!=null)
			genToken(ip, name);
		return this;
	}
	
	public TopoNode setTimes(int times) {
		this.times = times;
		return this;
	}
	public TopoNode addOnce() {
		this.times ++;
		return this;
	}
	
	public String getIp() {
		return ip;
	}
	
	public String getName() {
		return name;
	}
	
	public String getToken() {
		return token;
	}
	
	public int getTimes() {
		return times;
	}
	
	@Override
	public String toString() {
		return "TopoNode{" +
				"ip='" + ip + '\'' +
				", name='" + name + '\'' +
				", times=" + times +
				'}';
	}
	
	@Override
	public int hashCode() {
		return token.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof TopoNode && token.equals(((TopoNode) obj).token);
	}
}
