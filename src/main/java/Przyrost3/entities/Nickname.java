package Przyrost3.entities;

import javax.persistence.*;

@Entity
@Table(name = "NICKNAME", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id"})})
public class Nickname {

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public Nickname() {}

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
}
