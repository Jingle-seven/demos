package xz.model;

import lombok.*;
import javax.persistence.*;

@Table(name="tb_user")
@Entity
@Getter
@Setter
public class User {
    public User(){}
    public User(String name, String account) {
        this.name = name;
        this.account = account;
    }

    @Id
    @GeneratedValue//主键生成策略.四个生成策略分别对应mysql,oracle,所有数据库(用一个表保存主键),自动选择
    //垃圾,我提莫要自己控制主键生成策略,居然不给设置?
    public Long id;
    @Column
    public String name;
    @Column
    public String account;
    @ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name="dept_id")
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