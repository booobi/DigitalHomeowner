package DigitalHomeowner.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class PaymentEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @ManyToOne
    private Building building;

    private Double amountPayed;

    private Date datePayed;

    private Integer monthForPayed;

    public PaymentEntry() {}

    public PaymentEntry(Building building, Double amountPayed, Date datePayed, Integer monthForPayed) {
        this.building = building;
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

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
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
}
