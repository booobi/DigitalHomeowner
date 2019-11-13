package DigitalHomeowner.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    String id;

    String firstName;
    String lastName;
    Integer age;
    String gender;
    Boolean isEmployee;
}
