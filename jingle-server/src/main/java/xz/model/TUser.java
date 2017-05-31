package xz.model;

public class TUser {
    private Long id;

    private String name;

    private String account;

    private String password;

    private Byte authority;

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public String getAccount() {
        return account;
    }


    public String getPassword() {
        return password;
    }


    public Byte getAuthority() {
        return authority;
    }
    
    public TUser setId(Long id) {
        this.id = id;
        return this;
    }
    
    public TUser setName(String name) {
        this.name = name;
        return this;
    }
    
    public TUser setAccount(String account) {
        this.account = account;
        return this;
    }
    
    public TUser setPassword(String password) {
        this.password = password;
        return this;
    }
    
    public TUser setAuthority(Byte authority) {
        this.authority = authority;
        return this;
    }
}