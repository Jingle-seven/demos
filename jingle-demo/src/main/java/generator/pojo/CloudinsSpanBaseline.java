package generator.pojo;

public class CloudinsSpanBaseline {
    private Long traceId;

    private Long id;

    private String traceMd5;

    private String name;

    private Long parentId;

    private Long startTs;

    private Long duration;

    public Long getTraceId() {
        return traceId;
    }

    public void setTraceId(Long traceId) {
        this.traceId = traceId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTraceMd5() {
        return traceMd5;
    }

    public void setTraceMd5(String traceMd5) {
        this.traceMd5 = traceMd5;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getStartTs() {
        return startTs;
    }

    public void setStartTs(Long startTs) {
        this.startTs = startTs;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }
}