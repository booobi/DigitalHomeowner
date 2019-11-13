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

    public Building() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getFloors() {
        return floors;
    }

    public void setFloors(Integer floors) {
        this.floors = floors;
    }

    public Integer getApartments() {
        return apartments;
    }

    public void setApartments(Integer apartments) {
        this.apartments = apartments;
    }

    public Double getBuildArea() {
        return buildArea;
    }

    public void setBuildArea(Double buildArea) {
        this.buildArea = buildArea;
    }

    public Double getCommonArea() {
        return commonArea;
    }

    public void setCommonArea(Double commonArea) {
        this.commonArea = commonArea;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }
}
