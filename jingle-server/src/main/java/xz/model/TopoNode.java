package xz.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Jinhua on 2017/5/4.
 */
public class TopoNode {
	private String ip;
	private String name;
	public String token;
	private Set<TopoNode> parents;
//	private TopoNode parent;
	private int times = 1;
	private int depth = -1;
	
	public TopoNode(String ip, String name) {
		this.ip = ip;
		this.name = name;
		genToken(ip, name);
		parents = new HashSet<>();
	}
	
	private void genToken(String ip, String name) {
		this.token =  String.format("%s[%s]",name,ip);
	}
	public synchronized void genDepth() {
		if(parents.size()==0 || (parents.size()==1 && parents.contains(this))) {
			depth = 0;
			return;
		}
		this.depth = findParentDepth()+1;
	}
	public int findParentDepth(){
		int parentDepth = 0;
		for(TopoNode p: parents){
			if(p.getDepth()==-1)
				p.genDepth();
			if(parentDepth < p.getDepth())
				parentDepth = p.getDepth();
		}
		return parentDepth;
	}
	public TopoNode setParent(TopoNode parent) {
		this.parents.add(parent);
		return this;
	}
	public List<String> getParents() {
		return parents.stream()
				.map(TopoNode::getToken)
				.collect(Collectors.toList());
	}
	
	public synchronized int getDepth() {
		return depth;
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
