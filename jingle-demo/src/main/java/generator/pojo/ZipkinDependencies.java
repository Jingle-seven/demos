package generator.pojo;

import java.util.Date;

public class ZipkinDependencies {
    private Date day;

    private String parent;

    private String child;

    private Long callCount;

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }

    public Long getCallCount() {
        return callCount;
    }

    public void setCallCount(Long callCount) {
        this.callCount = callCount;
    }
}