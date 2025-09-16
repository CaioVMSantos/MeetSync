package com.example.MeetSync.core.enums;

public enum EventType {
    CONFERENCE("Conferência"),
    WORKSHOP("Workshop"),
    MEETUP("Meetup"),
    SEMINAR("Seminário"),
    WEBINAR("Webinar"),
    HACKATHON("Hackathon"),
    CONCERT("Show / Concerto"),
    FESTIVAL("Festival"),
    THEATER_PLAY("Peça de Teatro"),
    EXHIBITION("Exposição"),
    SPORTING_EVENT("Evento Esportivo"),
    PARTY("Festa"),
    WEDDING("Casamento"),
    COMMUNITY_GATHERING("Encontro Comunitário"),
    OTHER("Outro");

    private final String displayName;

    EventType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
