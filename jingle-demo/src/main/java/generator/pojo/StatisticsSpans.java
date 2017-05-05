package generator.pojo;

public class StatisticsSpans {
    private Integer id;

    private String startTime;

    private String endTime;

    private String spanName;

    private String calledNum;

    private String avgTime;

    private String slowestId;

    private String slowestTime;

    private String slowestHost;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getSpanName() {
        return spanName;
    }

    public void setSpanName(String spanName) {
        this.spanName = spanName;
    }

    public String getCalledNum() {
        return calledNum;
    }

    public void setCalledNum(String calledNum) {
        this.calledNum = calledNum;
    }

    public String getAvgTime() {
        return avgTime;
    }

    public void setAvgTime(String avgTime) {
        this.avgTime = avgTime;
    }

    public String getSlowestId() {
        return slowestId;
    }

    public void setSlowestId(String slowestId) {
        this.slowestId = slowestId;
    }

    public String getSlowestTime() {
        return slowestTime;
    }

    public void setSlowestTime(String slowestTime) {
        this.slowestTime = slowestTime;
    }

    public String getSlowestHost() {
        return slowestHost;
    }

    public void setSlowestHost(String slowestHost) {
        this.slowestHost = slowestHost;
    }
}