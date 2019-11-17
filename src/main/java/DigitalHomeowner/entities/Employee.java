package DigitalHomeowner.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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
    Set<Building> managedBuildings;

    public Employee() {}

    public Employee(String firstName, String lastName, Integer age, String gender, Set<Building> managedBuildings) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.managedBuildings = managedBuildings;
    }

    public void addManagedBuilding(Building building) {
        this.managedBuildings.add(building);
    }
    public void removeManagedBuilding(Building building) {
        this.managedBuildings.remove(building);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Set<Building> getManagedBuildings() {
        return managedBuildings;
    }

    public void setManagedBuildings(Set<Building> managedBuildings) {
        this.managedBuildings = managedBuildings;
    }
}
