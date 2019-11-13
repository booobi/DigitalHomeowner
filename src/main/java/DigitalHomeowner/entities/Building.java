package DigitalHomeowner.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Building {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    String id;

    String address;
    Integer floors;
    Integer apartments;
    Double buildArea;
    Double commonArea;

    @OneToMany(mappedBy = "building")
    List<Person> people;

    public Building(String address, Integer floors, Integer apartments, Double buildArea, Double commonArea, List<Person> people) {
        this.address = address;
        this.floors = floors;
        this.apartments = apartments;
        this.buildArea = buildArea;
        this.commonArea = commonArea;
        this.people = people;
    }
}
