package DigitalHomeowner.repositories;

import DigitalHomeowner.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
