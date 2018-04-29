package xz.model;

import io.ebean.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

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
    @Column
    public String name;
    @JsonIgnore
    @OneToMany(cascade={ CascadeType.ALL },mappedBy = "dept")
    public List<User> users = new ArrayList<>();

    public Dept addUser(User user){
        users.add(user);
        return this;
    }
}