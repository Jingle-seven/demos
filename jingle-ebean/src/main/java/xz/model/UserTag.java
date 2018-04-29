package xz.model;

import xz.util.XKit;

import javax.persistence.*;
import java.util.List;

@Table(name="tb_tag")
@Entity
public class UserTag {

    @Id
    public Long id;
    public String tagName;
//    @ManyToMany
//    @JoinTable(name="tb_user_tag",
//            joinColumns={@JoinColumn(name="tag_id")},
//            inverseJoinColumns={@JoinColumn(name="user_id")})
//    public List<User> users;

    public UserTag setTagName(String tagName) {
        this.tagName = tagName;
        return this;
    }

    public UserTag setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return XKit.toStr(this);
    }
}