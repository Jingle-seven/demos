package xz.model.wrapper;


import xz.model.Asset;
import xz.model.AssetUser;
import xz.util.WrapperFactory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jinhua on 2017/7/6 11:03.
 */
public class UserWrapper extends AssetUser {
    private Map<Long,Asset> assetsUsing = new HashMap<>();
    private Map<Long,Asset> assetsOwning = new HashMap<>();
    
    public String findPassword() {
        return super.getPassword();
    }
    @Override
    public String getPassword() {
        return "***";
    }
    
    public Collection<Asset> getAssetsUsing() {
        return assetsUsing.values();
    }
    
    public Collection<Asset> getAssetsOwning() {
        return assetsOwning.values();
    }
    
    public Map<Long,Asset> putAssetUsing(Asset as){
        assetsUsing.put(as.getId(),as);
        return assetsUsing;
    }
    public Map<Long,Asset> putAssetOwning(Asset as){
        assetsOwning.put(as.getId(),as);
        return assetsOwning;
    }
    public<E extends Asset> Map<Long,Asset> putAssetUsing(Collection<E> ass){
        ass.forEach(as->assetsUsing.put(as.getId(),as));
        return assetsUsing;
    }
    public<E extends Asset> Map<Long,Asset> putAssetOwning(Collection<E> ass){
        ass.forEach(as->assetsOwning.put(as.getId(),as));
        return assetsOwning;
    }
    
    @Override
    public String toString() {
        return WrapperFactory.toStr(this);
    }
    
    public String[] toMeta(){
        return new String[]{"id:"+super.getId(),"account:"+super.getAccount(),"name:"+super.getName()};
    }
}
