package xz.model;

public class AssetUser extends BaseRecord{
    private String name;

    private String account;

    private String password;

    private Byte authority;

    private String department;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Byte getAuthority() {
        return authority;
    }

    public void setAuthority(Byte authority) {
        this.authority = authority;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    
}