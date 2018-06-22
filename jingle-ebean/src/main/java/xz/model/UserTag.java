package xz.model;

import xz.util.XKit;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name="tb_tag")
@Entity
public class UserTag {

    @Id
    public Long id;
    public String tagName;
//    @ManyToMany//ManyToMany是不可能的
//    @JoinTable(name="tb_user_tag",
//            joinColumns={@JoinColumn(name="tag_id")},
//            inverseJoinColumns={@JoinColumn(name="user_id")})
    @OneToMany(cascade = CascadeType.PERSIST)//这里加了约束的话,对方外键不能为空.仅仅是对方加可以为空
    //一对多,多方外键名是name,默认为[本表_本表主键],这与多对一不同,详见user.dept
    //referencedColumnName不写默认为本表主键,写也必须写本表主键
//    @JoinColumn(name="user_tag_id",referencedColumnName = "id")
    public List<UserTag> children;

    public UserTag setTagName(String tagName) {
        this.tagName = tagName;
        return this;
    }

    public UserTag setId(Long id) {
        this.id = id;
        return this;
    }

    public UserTag addChild(UserTag user) {
        if(children ==null)
            children = new ArrayList<>();
        this.children.add(user);
        return this;
    }

    @Override
    public String toString() {
        return XKit.toStr(this);
    }
}