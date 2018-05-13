package xz.model;

import java.util.Collection;

public class JsonResp<E> {
    private Status statusEnum;
    private String message;
    public int count;
    public Collection<E> data;
    public JsonResp(){
        statusEnum = Status.SUCCESS;
        message = statusEnum.message;
    }

    public Integer getCode() {
        return statusEnum.statusCode;
    }

    public JsonResp setStatus(Status status) {
        statusEnum = Status.SUCCESS;
        message = statusEnum.message;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public JsonResp setMessage(String message) {
        this.message = message;
        return this;
    }

    public int getCount() {
        return count;
    }

    public JsonResp<E> setCount(int count) {
        this.count = count;
        return this;
    }

    public Collection<E> getData() {
        return data;
    }

    public JsonResp<E> setData(Collection<E> data) {
        this.data = data;
        return this;
    }

    public enum Status {
        SUCCESS(1, "SUCCESS"), FAILURE(1, "FAILURE");

        Status(int statusCode, String message) {
            this.statusCode = statusCode;
            this.message = message;
        }

        public int statusCode;
        public String message;
    }
}
