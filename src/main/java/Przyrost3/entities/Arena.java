package Przyrost3.entities;

import javax.persistence.*;

@Entity
@Table(name = "ARENA", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id"})})
public class Arena {

    @Id @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Arena() {
    }

    public Arena(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Arena(Arena arena) {
        this.id=arena.getId();
        this.name = arena.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
