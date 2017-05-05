package generator.pojo;

public class Traces {
    private Long traceId;

    private String traceMd5;

    private Long startTs;

    private Long duration;

    private Long endTs;

    private Short teamCode;

    public Long getTraceId() {
        return traceId;
    }

    public void setTraceId(Long traceId) {
        this.traceId = traceId;
    }

    public String getTraceMd5() {
        return traceMd5;
    }

    public void setTraceMd5(String traceMd5) {
        this.traceMd5 = traceMd5;
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

    public Long getEndTs() {
        return endTs;
    }

    public void setEndTs(Long endTs) {
        this.endTs = endTs;
    }

    public Short getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(Short teamCode) {
        this.teamCode = teamCode;
    }
}