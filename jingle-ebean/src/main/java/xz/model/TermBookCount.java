package xz.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TermBookCount {
    public String term;
    public LocalDate startDate;
    public LocalDate endDate;
    public int count;

    public String getTerm() { return term; }
    public String getStartDate() { return DateTimeFormatter.ISO_LOCAL_DATE.format(startDate); }
    public String getEndDate() { return DateTimeFormatter.ISO_LOCAL_DATE.format(endDate); }
    public int getCount() { return count; }

    public TermBookCount setTerm(String term) {
        this.term = term;
        return this;
    }

    public TermBookCount setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public TermBookCount setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public TermBookCount setCount(int count) {
        this.count = count;
        return this;
    }
    public boolean isInTheTerm(LocalDate date){
        return date.isAfter(startDate)  && date.isBefore(endDate);
    }
}
