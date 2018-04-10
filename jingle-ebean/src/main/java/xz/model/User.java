package xz.model;

import lombok.*;
import javax.persistence.*;

@Table(name="t_user")
@Entity
@Getter
@Setter
public class User {
    public User(String name, String account) {
        this.name = name;
        this.account = account;
    }

    @Id
    @GeneratedValue
    public Long id;
    @Column
    public String name;
    @Column
    public String account;
}