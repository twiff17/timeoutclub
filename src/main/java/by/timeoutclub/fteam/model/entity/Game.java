package by.timeoutclub.fteam.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Game extends RepresentationModel<Game> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String competitor;
    private int scored;
    private int conceded;
    private LocalDate date;
    @JsonManagedReference
    @OneToMany(mappedBy = "game")
    private List<Event> events;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompetitor() {
        return competitor;
    }

    public void setCompetitor(String competitor) {
        this.competitor = competitor;
    }

    public int getScored() {
        return scored;
    }

    public void setScored(int scored) {
        this.scored = scored;
    }

    public int getConceded() {
        return conceded;
    }

    public void setConceded(int conceded) {
        this.conceded = conceded;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
