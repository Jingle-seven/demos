package xz.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import xz.util.XKit;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Entity
public class Book {
    @Id
    private String id;
    private String name;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private LocalDate returnDate;
    private Integer UserId;
    private String userName;

    public String getId() {
        return id;
    }

    public Book setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Book setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate date() { return date; }
    public LocalDate returnDate() { return returnDate; }
    public String getDate() { return DateTimeFormatter.ISO_LOCAL_DATE.format(date); }
    public String getReturnDate() { return DateTimeFormatter.ISO_LOCAL_DATE.format(returnDate); }
    public int getPeriod() {
        Period range = Period.between(date,returnDate);
        return range.getDays();
    }

    public Book setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public Integer getUserId() {
        return UserId;
    }

    public Book setUserId(Integer userId) {
        UserId = userId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public Book setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    @Override
    public String toString() {
        return XKit.toStr(this);
    }
}
