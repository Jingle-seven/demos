package xz.model.wrapper;


import xz.util.WrapperFactory;

/**
 * Created by Jinhua on 2017/6/16 11:44.
 */
public class AssetHistWrapper extends AssetWrapper {
	private String operation;
	private String assetId;
	
	public String getOperation() {
		return operation;
	}
	
	public AssetHistWrapper setOperation(String operation) {
		this.operation = operation;
		return this;
	}
	
	public String getAssetId() {
		return assetId;
	}
	
	public AssetHistWrapper setAssetId(String assetId) {
		this.assetId = assetId;
		return this;
	}
	
	@Override
	public String toString() {
		return WrapperFactory.toStr(this);
	}
	
}
