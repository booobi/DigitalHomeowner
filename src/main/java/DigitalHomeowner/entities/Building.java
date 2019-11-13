package DigitalHomeowner.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
}
