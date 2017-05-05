package generator.pojo;

public class ZipkinAnnotations {
    private Long traceId;

    private Long spanId;

    private String aKey;

    private Integer aType;

    private Long aTimestamp;

    private Integer endpointIpv4;

    private Short endpointPort;

    private String endpointServiceName;

    private byte[] aValue;

    private byte[] endpointIpv6;

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

    public String getaKey() {
        return aKey;
    }

    public void setaKey(String aKey) {
        this.aKey = aKey;
    }

    public Integer getaType() {
        return aType;
    }

    public void setaType(Integer aType) {
        this.aType = aType;
    }

    public Long getaTimestamp() {
        return aTimestamp;
    }

    public void setaTimestamp(Long aTimestamp) {
        this.aTimestamp = aTimestamp;
    }

    public Integer getEndpointIpv4() {
        return endpointIpv4;
    }

    public void setEndpointIpv4(Integer endpointIpv4) {
        this.endpointIpv4 = endpointIpv4;
    }

    public Short getEndpointPort() {
        return endpointPort;
    }

    public void setEndpointPort(Short endpointPort) {
        this.endpointPort = endpointPort;
    }

    public String getEndpointServiceName() {
        return endpointServiceName;
    }

    public void setEndpointServiceName(String endpointServiceName) {
        this.endpointServiceName = endpointServiceName;
    }

    public byte[] getaValue() {
        return aValue;
    }

    public void setaValue(byte[] aValue) {
        this.aValue = aValue;
    }

    public byte[] getEndpointIpv6() {
        return endpointIpv6;
    }

    public void setEndpointIpv6(byte[] endpointIpv6) {
        this.endpointIpv6 = endpointIpv6;
    }
}