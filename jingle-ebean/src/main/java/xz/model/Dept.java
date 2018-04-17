package xz.model;

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
    @GeneratedValue
    public Long id;
    @Column
    public String name;
    @OneToMany(cascade={ CascadeType.ALL },mappedBy = "dept")
    public List<User> users = new ArrayList<>();
}