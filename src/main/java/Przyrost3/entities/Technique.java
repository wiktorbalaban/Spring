package Przyrost3.entities;

import javax.persistence.*;

@Entity
@Table(name = "TECHNIQUE", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id"})})
public class Technique {

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "percentagetopower")
    private int percentagetopower;

    public Technique() {
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

    public int getPercentagetopower() {
        return percentagetopower;
    }

    public void setPercentagetopower(int percentagetopower) {
        this.percentagetopower = percentagetopower;
    }
}
