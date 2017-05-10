package xz.model;

import java.util.Objects;

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
	
	public String getSource() {
		return source;
	}
	
	public String getTarget() {
		return target;
	}
	
	@Override
	public String toString() {
		return "TopoLink{" +
				"source='" + source + '\'' +
				", target='" + target + '\'' +
				'}';
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TopoLink topoLink = (TopoLink) o;
		return Objects.equals(source, topoLink.source) &&
				Objects.equals(target, topoLink.target);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(source, target);
	}
}
