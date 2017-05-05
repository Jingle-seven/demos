package generator.pojo;

public class SpanCopy {
    private Long traceId;

    private Long spanId;

    private Integer endpointIpv4;

    private String endpointServiceName;

    private Long startTs;

    private Long duration;

    private Long recordTs;

    private String traceMd5;

    private Long parentId;

    private Integer parentIp;

    private String parentEndpointName;

    public Long getTraceId() {
        return traceId;
    }

    public void setTraceId(Long traceId) {
        this.traceId = traceId;
    }

    public Long getSpanId() {
        return spanId;
    }

    public void setSpanId(Long spanId) {
        this.spanId = spanId;
    }

    public Integer getEndpointIpv4() {
        return endpointIpv4;
    }

    public void setEndpointIpv4(Integer endpointIpv4) {
        this.endpointIpv4 = endpointIpv4;
    }

    public String getEndpointServiceName() {
        return endpointServiceName;
    }

    public void setEndpointServiceName(String endpointServiceName) {
        this.endpointServiceName = endpointServiceName;
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

    public Long getRecordTs() {
        return recordTs;
    }

    public void setRecordTs(Long recordTs) {
        this.recordTs = recordTs;
    }

    public String getTraceMd5() {
        return traceMd5;
    }

    public void setTraceMd5(String traceMd5) {
        this.traceMd5 = traceMd5;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getParentIp() {
        return parentIp;
    }

    public void setParentIp(Integer parentIp) {
        this.parentIp = parentIp;
    }

    public String getParentEndpointName() {
        return parentEndpointName;
    }

    public void setParentEndpointName(String parentEndpointName) {
        this.parentEndpointName = parentEndpointName;
    }
}