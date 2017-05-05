package generator.pojo;

public class CloudinsConfig {
    private Long id;

    private String product;

    private String module;

    private String parmAlias;

    private String parmName;

    private String parmValue;

    private Integer flag;

    private String comment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getParmAlias() {
        return parmAlias;
    }

    public void setParmAlias(String parmAlias) {
        this.parmAlias = parmAlias;
    }

    public String getParmName() {
        return parmName;
    }

    public void setParmName(String parmName) {
        this.parmName = parmName;
    }

    public String getParmValue() {
        return parmValue;
    }

    public void setParmValue(String parmValue) {
        this.parmValue = parmValue;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}