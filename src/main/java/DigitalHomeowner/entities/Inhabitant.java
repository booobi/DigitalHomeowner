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

    public Inhabitant() {
    }

    public Inhabitant(String name, Building building) {
         this.name = name;
         this.building = building;
    }
}
