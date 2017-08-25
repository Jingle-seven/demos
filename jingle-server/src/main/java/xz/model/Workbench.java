package xz.model;

import xz.model.abst.BaseRecord;

public class Workbench extends BaseRecord {

    private String number;

    private String description;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}