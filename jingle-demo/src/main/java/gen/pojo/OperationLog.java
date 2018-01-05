package gen.pojo;

import java.util.Date;

public class OperationLog {
    private Long id;

    private Date datetime;

    private String user;

    private String operationSql;

    private String status;

    private String operation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getOperationSql() {
        return operationSql;
    }

    public void setOperationSql(String operationSql) {
        this.operationSql = operationSql;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}