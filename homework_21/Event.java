package com.proftelran.org.homework_21;

import java.time.LocalDate;

public class Event {
    private int eventId;
    private String userName;
    private String userIp;
    private LocalDate eventDate;
    private EventState eventState;

    public Event(int eventId, String userName, String userIp, LocalDate eventDate, EventState eventState) {
        this.eventId = eventId;
        this.userName = userName;
        this.userIp = userIp;
        this.eventDate = eventDate;
        this.eventState = eventState;
    }

    public int getEventId() {
        return eventId;
    }
    public String getUserName() {
        return userName;
    }
    public String getUserIp() {
        return userIp;
    }
    public LocalDate getEventDate() {
        return eventDate;
    }
    public EventState getEventState() {
        return eventState;
    }

}
