package Przyrost3.entities;

import javax.persistence.*;

@Entity
@Table(name = "ARENA", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id"})})
public class Arena {

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public Arena() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
