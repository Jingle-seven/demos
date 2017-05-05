package generator.pojo;

public class TraceInfos {
    private String traceMd5;

    private String rootName;

    private String traceName;

    private Short spanCount;

    private String traceAlias;

    private Long baseTraceId;

    private Long warningDuration;

    private Integer warningPercentage;

    public String getTraceMd5() {
        return traceMd5;
    }

    public void setTraceMd5(String traceMd5) {
        this.traceMd5 = traceMd5;
    }

    public String getRootName() {
        return rootName;
    }

    public void setRootName(String rootName) {
        this.rootName = rootName;
    }

    public String getTraceName() {
        return traceName;
    }

    public void setTraceName(String traceName) {
        this.traceName = traceName;
    }

    public Short getSpanCount() {
        return spanCount;
    }

    public void setSpanCount(Short spanCount) {
        this.spanCount = spanCount;
    }

    public String getTraceAlias() {
        return traceAlias;
    }

    public void setTraceAlias(String traceAlias) {
        this.traceAlias = traceAlias;
    }

    public Long getBaseTraceId() {
        return baseTraceId;
    }

    public void setBaseTraceId(Long baseTraceId) {
        this.baseTraceId = baseTraceId;
    }

    public Long getWarningDuration() {
        return warningDuration;
    }

    public void setWarningDuration(Long warningDuration) {
        this.warningDuration = warningDuration;
    }

    public Integer getWarningPercentage() {
        return warningPercentage;
    }

    public void setWarningPercentage(Integer warningPercentage) {
        this.warningPercentage = warningPercentage;
    }
}