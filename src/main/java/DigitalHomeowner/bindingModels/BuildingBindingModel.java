package DigitalHomeowner.bindingModels;

import java.util.List;

public class BuildingBindingModel {
    public String address;
    public Integer floors;
    public Integer apartments;
    public Double buildingArea;
    public Double commonArea;
    public Double amountToPay;

    public List<String> inhabitants;

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

    public Double getBuildingArea() {
        return buildingArea;
    }

    public void setBuildingArea(Double buildingArea) {
        this.buildingArea = buildingArea;
    }

    public Double getCommonArea() {
        return commonArea;
    }

    public void setCommonArea(Double commonArea) {
        this.commonArea = commonArea;
    }

    public List<String> getInhabitants() {
        return inhabitants;
    }

    public void setInhabitants(List<String> inhabitants) {
        this.inhabitants = inhabitants;
    }

    public Double getAmountToPay() {
        return amountToPay;
    }

    public void setAmountToPay(Double amountToPay) {
        this.amountToPay = amountToPay;
    }
}
