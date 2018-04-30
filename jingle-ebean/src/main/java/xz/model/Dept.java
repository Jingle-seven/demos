package xz.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import xz.util.XKit;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name="tb_dept")
@Entity
@Getter
@Setter
public class Dept {
    public Dept(String name) {
        this.name = name;
    }

    @Id
    public Long id;
    public String name;

    @JsonIgnore//ebean 提供的JsonIgnore注解无效,要使用jackson自己的
//    @JoinColumn(name="ok") //在多方配置JoinColumn似乎毫无作用
    //mappedBy只能配置在多方,值为对方对自己的称呼(user.dept)
    //据说mappedBy可以防止重复更新,但以我对ebean的测试结果来看,不配置也没有重复更新
    //cascade的理解是:我单方面断绝或者建立关系会不会影响我们的关系,似乎与mappedBy毫无关系
    //so,如果想维护自己的外键,那就自己配置cascade,想别人维护就让别人配置cascade,而与mappedBy没关系
    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "dept")
    public List<User> users = new ArrayList<>();

    public Dept addUser(User user){
        users.add(user);
        return this;
    }

    @Override
    public String toString() {
        List<User> l = new ArrayList<>(users.size());
        l.addAll(users);
        return "Dept{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", users=" + l +
                '}';
    }
}