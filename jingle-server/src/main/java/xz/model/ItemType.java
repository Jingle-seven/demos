package xz.model;


import xz.util.WrapperFactory;

public class ItemType extends BaseRecord{

    private Long number;

    private String tableName;

    private String itemName;

    private String title;

    private String comment;
    
    private Byte deletable = 0;
    
    public Byte getDeletable() {
        return deletable;
    }
    
    public ItemType setDeletable(Byte deletable) {
        this.deletable = deletable;
        return this;
    }
    
    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    
    @Override
    public String toString() {
        return WrapperFactory.toStr(this);
    }
}