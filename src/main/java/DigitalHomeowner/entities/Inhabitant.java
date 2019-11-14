package DigitalHomeowner.entities;

import javax.persistence.*;

@Entity
public class Inhabitant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String Id;

    String name;

    @ManyToOne
    Building building;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Inhabitant() {
    }

    public Inhabitant(String name, Building building) {
         this.name = name;
         this.building = building;
    }
}
