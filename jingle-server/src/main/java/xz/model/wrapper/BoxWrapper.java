package xz.model.wrapper;


import xz.model.PoolCabinet;
import xz.util.WrapperFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jinhua on 2017/7/3 10:32.
 */
public class BoxWrapper extends PoolCabinet {
    private Long assetId;
    private List<Long> assetIds = new ArrayList<>();
    
    public void addAssetId(Long assetId){assetIds.add(assetId);}
    
    public Long findAssetId() {
        return assetId;
    }
    
    public BoxWrapper setAssetId(Long assetId) {
        this.assetId = assetId;
        return this;
    }
    
    public List<Long> getAssetIds() {
        return assetIds;
    }
    
    @Override
    public String toString() {
        return WrapperFactory.toStr(this);
    }
    
    
}
