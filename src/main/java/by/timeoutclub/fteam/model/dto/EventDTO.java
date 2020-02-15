package by.timeoutclub.fteam.model.dto;

import by.timeoutclub.fteam.model.entity.EventType;

import javax.validation.constraints.NotNull;

public class EventDTO {

    @NotNull
    private EventType type;
    @NotNull
    private Integer playerId;

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
}
