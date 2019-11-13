package DigitalHomeowner.repositories;

import DigitalHomeowner.entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository extends JpaRepository<Building, String> {
}
