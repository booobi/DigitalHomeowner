package DigitalHomeowner.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class PaymentEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String buildingAddress;

    private Double amountPayed;

    private Date datePayed;

    private Integer monthForPayed;

    public PaymentEntry() {}

    public PaymentEntry(String buildingAddress, Double amountPayed, Date datePayed, Integer monthForPayed) {
        this.buildingAddress = buildingAddress;
        this.amountPayed = amountPayed;
        this.datePayed = datePayed;
        this.monthForPayed = monthForPayed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBuildingAddress() {
        return buildingAddress;
    }

    public void setBuildingAddress(String buildingAddress) {
        this.buildingAddress = buildingAddress;
    }

    public Double getAmountPayed() {
        return amountPayed;
    }

    public void setAmountPayed(Double amountPayed) {
        this.amountPayed = amountPayed;
    }

    public Date getDatePayed() {
        return datePayed;
    }

    public void setDatePayed(Date datePayed) {
        this.datePayed = datePayed;
    }

    public Integer getMonthForPayed() {
        return monthForPayed;
    }

    public void setMonthForPayed(Integer monthForPayed) {
        this.monthForPayed = monthForPayed;
    }

    public String getMonthForPayedString() {
        switch (this.getMonthForPayed()) {
            case 1: return "January";
            case 2: return "February";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
            default: return "Test";
        }
    }
}
