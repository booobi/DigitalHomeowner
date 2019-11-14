package DigitalHomeowner.entities;

import javax.persistence.*;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;

    @Column(nullable = false)
    String firstName;

    @Column(nullable = false)
    String lastName;

    @Column(nullable = false)
    Integer age;

    @Column(nullable = false)
    String gender;

    @ManyToOne()
    Building inhibitedBuilding;

    Boolean isEmployee;
    @OneToOne()
    Building managedBuilding;
}
