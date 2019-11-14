package DigitalHomeowner.repositories;

import DigitalHomeowner.entities.Inhabitant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InhabitantRepository extends JpaRepository<Inhabitant, String> {

}
