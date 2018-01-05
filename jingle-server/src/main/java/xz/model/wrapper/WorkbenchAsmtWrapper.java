package xz.model.wrapper;


import xz.model.WorkbenchAssignment;
import xz.util.WrapperFactory;

public class WorkbenchAsmtWrapper extends WorkbenchAssignment {

    private String userName;
    private String number;
    private String description;
    
    public String getNumber() {
        return number;
    }
    
    public WorkbenchAsmtWrapper setNumber(String number) {
        this.number = number;
        return this;
    }
    
    public String getDescription() {
        return description;
    }
    
    public WorkbenchAsmtWrapper setDescription(String description) {
        this.description = description;
        return this;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public WorkbenchAsmtWrapper setUserName(String userName) {
        this.userName = userName;
        return this;
    }
    
    @Override
    public String toString() {
        return WrapperFactory.toStr(this);
    }
}