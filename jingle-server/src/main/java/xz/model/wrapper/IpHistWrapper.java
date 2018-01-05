package xz.model.wrapper;


import xz.util.WrapperFactory;

/**
 * Created by Jinhua on 2017/6/16 11:44.
 */
public class IpHistWrapper extends IpWrapper {
	private String operation;
	private String ipId;
	
	public String getOperation() {
		return operation;
	}
	
	public IpHistWrapper setOperation(String operation) {
		this.operation = operation;
		return this;
	}
	
	public String getIpId() {
		return ipId;
	}
	
	public IpHistWrapper setIpId(String ipId) {
		this.ipId = ipId;
		return this;
	}
	
	@Override
	public String toString() {
		return WrapperFactory.toStr(this);
	}
	
}
