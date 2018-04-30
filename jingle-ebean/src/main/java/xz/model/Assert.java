package xz.model;

/**
 * Created by admin on 2018/4/30.
 */
public enum Assert {
    SHARE("股票",10),FUND("基金",99);
    private String gender;
    private int amount;
    private Assert(String name,int amount){
        this.gender=name;
        this.amount=amount;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getName(){
        return gender;
    }
    public int getAmount(){
        return amount;
    }

}
