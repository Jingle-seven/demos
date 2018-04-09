package xz.model;

import lombok.*;
import javax.persistence.*;

@Table(name="t_user")
@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String account;
}