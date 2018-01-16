package Przyrost3.entities;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.persistence.*;
import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TOURNAMENT", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id"})})
public class Tournament {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date")
    private LocalDate date;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ARENA_ID")
    private Arena arena;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "PARTICIPANT", joinColumns = {@JoinColumn(name = "TOURNAMENT_ID")}, inverseJoinColumns = {@JoinColumn(name = "WARRIOR_ID")})
    private List<Warrior> participants = new ArrayList<>();

    public Tournament() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Arena getArena() {
        return arena;
    }

    public void setArena(Arena arena) {
        this.arena = arena;
    }

    public List<Warrior> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Warrior> participants) {
        this.participants = participants;
    }

}
