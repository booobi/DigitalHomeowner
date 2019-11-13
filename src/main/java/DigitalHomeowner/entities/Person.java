package DigitalHomeowner.entities;

import javax.persistence.*;

@Entity
public class Person {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    String id;

    @Column(nullable = false)
    String firstName;

    @Column(nullable = false)
    String lastName;

    @Column(nullable = false)
    Integer age;

    @Column(nullable = false)
    String gender;

    @Column(nullable = false)
    Boolean isEmployee;

    @ManyToOne
    Building building;
}
