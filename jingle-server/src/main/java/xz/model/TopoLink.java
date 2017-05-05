package xz.model;

/**
 * Created by Jinhua on 2017/5/4.
 */
public class TopoLink {
	String source;
	String target;
	
	public TopoLink setSource(String source) {
		this.source = source;
		return this;
	}
	
	public TopoLink setTarget(String target) {
		this.target = target;
		return this;
	}
	
	
	@Override
	public String toString() {
		return "TopoLink{" +
				"source='" + source + '\'' +
				", target='" + target + '\'' +
				'}';
	}
}
