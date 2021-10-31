package dev.jacobandersen.pundasyon.obj.openweathermap;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class OpenWeatherMapWeatherAlert {
    /**
     * Sender of the weather alert
     * (see: https://openweathermap.org/api/one-call-api#listsource)
     */
    private String senderName;

    /**
     * Name of the weather alert
     */
    private String alert;

    /**
     * Description of the weather alert
     */
    private String description;

    /**
     * Tags indicating type of weather during the weather alert
     */
    private String tags;

    /**
     * Time the weather alert goes into effect (Unix timestamp)
     */
    private long start;

    /**
     * Time the weather alert lapses out of effect (Unix timestamp)
     */
    private long end;

    @JsonGetter("sender")
    public String getSenderName() {
        return senderName;
    }

    @JsonSetter("sender_name")
    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    @JsonGetter("alert")
    public String getAlert() {
        return alert;
    }

    @JsonSetter("event")
    public void setAlert(String alert) {
        this.alert = alert;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }
}
