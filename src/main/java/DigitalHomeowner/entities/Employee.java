package DigitalHomeowner.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {

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

    @OneToMany(mappedBy = "manager")
    List<Building> managedBuildings;
}
