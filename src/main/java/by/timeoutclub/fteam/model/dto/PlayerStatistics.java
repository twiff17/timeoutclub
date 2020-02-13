package by.timeoutclub.fteam.model.dto;

import by.timeoutclub.fteam.model.entity.EventType;

import java.util.Map;

public class PlayerStatistics {

    private String playerName;
    private long goals;
    private long assists;
    private long yellowCards;
    private long redCards;

    public PlayerStatistics(String playerName, Map<EventType, Long> eventCounts) {
        this.playerName = playerName;
        this.goals = eventCounts.getOrDefault(EventType.GOAL, 0L);
        this.assists = eventCounts.getOrDefault(EventType.ASSIST, 0L);
        this.yellowCards = eventCounts.getOrDefault(EventType.YELLOW, 0L);
        this.redCards = eventCounts.getOrDefault(EventType.RED, 0L);
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public long getGoals() {
        return goals;
    }

    public void setGoals(long goals) {
        this.goals = goals;
    }

    public long getAssists() {
        return assists;
    }

    public void setAssists(long assists) {
        this.assists = assists;
    }

    public long getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(long yellowCards) {
        this.yellowCards = yellowCards;
    }

    public long getRedCards() {
        return redCards;
    }

    public void setRedCards(long redCards) {
        this.redCards = redCards;
    }
}
