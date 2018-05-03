package xz.model;


import java.util.ArrayList;
import java.util.List;

public class Dept {
    public Dept(String name) {
        this.name = name;
    }

    public Long id;
    public String name;
    public List<User> users = new ArrayList<>();

    public Dept addUser(User user){
        users.add(user);
        return this;
    }
}