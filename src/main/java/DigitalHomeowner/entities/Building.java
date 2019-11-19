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
    Double amountToPay;

    @ManyToOne()
    Employee manager;

    @OneToMany(mappedBy = "building")
    List<Inhabitant> inhabitants;

    public Building(String address, Integer floors, Integer apartments, Double buildArea, Double commonArea, Double amountToPay, List<Inhabitant> inhabitants) {
        this.address = address;
        this.floors = floors;
        this.apartments = apartments;
        this.buildArea = buildArea;
        this.commonArea = commonArea;
        this.amountToPay = amountToPay;
        this.inhabitants = inhabitants;
    }

    public Building() {}

    public void addInhabitants(List<Inhabitant> inhabitants) {
        this.inhabitants.addAll(inhabitants);
    }

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

    public Double getAmountToPay() {
        return amountToPay;
    }

    public void setAmountToPay(Double amountToPay) {
        this.amountToPay = amountToPay;
    }

    public List<Inhabitant> getInhabitants() {
        return inhabitants;
    }

    public void setInhabitants(List<Inhabitant> inhabitants) {
        this.inhabitants = inhabitants;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }
}
