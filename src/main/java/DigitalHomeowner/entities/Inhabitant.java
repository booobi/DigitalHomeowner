package DigitalHomeowner.entities;

import javax.persistence.*;

@Entity
public class Inhabitant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String Id;

    String firstName;
    String lastName;
    Integer age;
    String gender;

    @ManyToOne
    Building building;
    public Inhabitant() {
    }

    public Inhabitant(String id, String firstName, String lastName, Integer age, String gender) {
        Id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }
}
