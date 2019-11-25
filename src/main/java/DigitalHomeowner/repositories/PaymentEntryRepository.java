package DigitalHomeowner.repositories;

import DigitalHomeowner.entities.Building;
import DigitalHomeowner.entities.PaymentEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentEntryRepository extends JpaRepository<PaymentEntry, String> {
    public List<PaymentEntry> getAllByBuildingAddress(String buildingAddress);
}
