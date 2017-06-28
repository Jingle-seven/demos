package xz.model;

import java.util.Date;

public class OperationLog {
    private Long id;

    private Date datetime;

    private String user;

    private String operation;

    private String operationSql;

    private String status;

    public Long getId() {
        return id;
    }


    public Date getDatetime() {
        return datetime;
    }


    public String getUser() {
        return user;
    }


    public String getOperation() {
        return operation;
    }

    public String getOperationSql() {
        return operationSql;
    }


    public String getStatus() {
        return status;
    }
    
    public OperationLog setId(Long id) {
        this.id = id;
        return this;
    }
    
    public OperationLog setDatetime(Date datetime) {
        this.datetime = datetime;
        return this;
    }
    
    public OperationLog setUser(String user) {
        this.user = user;
        return this;
    }
    
    public OperationLog setOperation(String operation) {
        this.operation = operation;
        return this;
    }
    
    public OperationLog setOperationSql(String operationSql) {
        this.operationSql = operationSql;
        return this;
    }
    
    public OperationLog setStatus(String status) {
        this.status = status;
        return this;
    }
}