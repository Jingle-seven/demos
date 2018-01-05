package xz.model.wrapper;


import xz.model.PoolNetwork;
import xz.util.WrapperFactory;

/**
 * Created by Jinhua on 2017/6/16 11:44.
 */
public class IpWrapper extends PoolNetwork {
	private String user;
	
	public String getUser() {
		return user;
	}
	
	public IpWrapper setUser(String user) {
		this.user = user;
		return this;
	}
	
	@Override
	public String toString() {
		return WrapperFactory.toStr(this);
	}
}
