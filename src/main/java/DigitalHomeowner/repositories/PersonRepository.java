package DigitalHomeowner.repositories;

import DigitalHomeowner.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, String> {
}
