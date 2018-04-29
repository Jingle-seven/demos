package xz.model;

import lombok.Getter;
import lombok.Setter;
import xz.util.XKit;

import javax.persistence.*;

@Table(name="tb_address")
@Entity
public class Address {

    @Id
    public Long postNumber;
    public String location;


    public Address setPostNumber(Long postNumber) {
        this.postNumber = postNumber;
        return this;
    }

    public Address setLocation(String location) {
        this.location = location;
        return this;
    }

    @Override
    public String toString() {
        return XKit.toStr(this);
    }
}