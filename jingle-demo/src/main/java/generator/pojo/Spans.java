package generator.pojo;

public class Spans {
    private Long traceId;

    private Long spanId;

    private Integer endpointIpv4;

    private String endpointServiceName;

    private Long startTs;

    private Long duration;

    private Long recordTs;

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
}