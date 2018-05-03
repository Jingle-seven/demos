package xz.model;

public class User {
    public User(){}
    public User(String name, String account) {
        this.name = name;
        this.account = account;
    }

    public Long id;
    public String name;
    public String account;
    public Dept dept;

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public User setAccount(String account) {
        this.account = account;
        return this;
    }

    public User setDept(Dept dept) {
        this.dept = dept;
        return this;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAccount() {
        return account;
    }

    public Dept getDept() {
        return dept;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", dept=" + dept +
                '}';
    }
}