package xz.model.wrapper;


import xz.model.IpSection;
import xz.util.WrapperFactory;

public class IpSectionWrapper extends IpSection {

    private String userName;
    
    public String getUserName() {
        return userName;
    }
    
    public IpSectionWrapper setUserName(String userName) {
        this.userName = userName;
        return this;
    }
    
    @Override
    public String toString() {
        return WrapperFactory.toStr(this);
    }
}