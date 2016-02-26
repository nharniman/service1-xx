package net.harniman.service1.api;

import java.util.Date;

public class DateConvertor {
    private long id;

    @Length(max = 3)
    private Date date;
    private DateTime dt;

    public DateConvertor() {
        // Jackson deserialization
    }

    public DateConvertor(long id, String date) {
        this.id = id;
        this.dt = new DateTime(date);
        this.date = dt.toDate();

    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getDate() {
        return date.toString();
    }

    @JsonProperty
    public long getSecondsSinceEPOCH() {
        return date.getTime();
    }

    @JsonProperty
    public String getMonthName() {
        return dt.monthOfYear().getAsText();
    }

    @JsonProperty
    public String getDayOfWeek() {
        return dt.dayOfWeek().getAsText();
    }

}