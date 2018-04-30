package xz.model;

import lombok.*;
import xz.util.XKit;

import javax.persistence.*;
import java.util.List;

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
    public String name;
    public String account;

    //如果(cascade=CascadeType.ALL),user的保存会影响到自己的外键,还会影响到dept表保存数据
    @ManyToOne(cascade=CascadeType.PERSIST)
    //@JoinColumn referencedColumnName 不赋值的话,默认选择对方的主键
    //name不赋值的话,默认数据库字段名称为 属性名_对方主键名
    public Dept dept;

    /**
     * CascadeType.PERSIST 级联保存
     * CascadeType.MERGE 级联合并
     * CascadeType.REMOVE 级联删除
     * CascadeType.REFRESH 级联刷新
     * CascadeType.DETACH 级联游离
     * CascadeType.ALL 以上
     * 但就ebean而言,似乎只用到了保存和删除
     */
    @OneToOne(cascade=CascadeType.ALL)
    public Address address;

    // 想manyTOMany?洗洗睡吧,辣鸡框架没人用是有原因的
//    @ManyToMany
//    @JoinTable(name="tb_user_tag",
//            joinColumns={@JoinColumn(name="user_id",referencedColumnName = "tag_id")},
//            inverseJoinColumns={@JoinColumn(name="tag_id",referencedColumnName = "user_id")})
//    public List<UserTag> userTags;

    //在数据库中以值(大写字母)而非序号来保存,默认序号
    @Enumerated(EnumType.STRING)
    public Assert anAssert;

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

    public User setAddress(Address address) {
        this.address = address;
        return this;
    }

    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", address=" + address +
                '}';
    }
    public String allToString() {
        return XKit.toStr(this);
    }
}