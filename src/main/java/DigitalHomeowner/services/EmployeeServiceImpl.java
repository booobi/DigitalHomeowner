package DigitalHomeowner.services;

import DigitalHomeowner.bindingModels.EmployeeBindingModel;
import DigitalHomeowner.entities.Building;
import DigitalHomeowner.entities.Employee;
import DigitalHomeowner.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class EmployeeServiceImpl extends EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void create(EmployeeBindingModel ebm, Set<Building> buildings) {

        Employee newEmployee = new Employee(
                ebm.getfName(),
                ebm.getlName(),
                ebm.getAge(),
                ebm.getGender(),
                buildings
        );

        for (Building b :
                buildings) {
            b.setManager(newEmployee);
        }

        this.employeeRepository.saveAndFlush(newEmployee);
    }

    @Override
    public List<Employee> getAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee getById(String id) {
        return this.employeeRepository.getOne(id);
    }

    @Override
    public void edit(String id, EmployeeBindingModel ebm, Set<Building> buildings) {
        Employee employee = this.employeeRepository.getOne(id);

        employee.setFirstName(ebm.getfName());
        employee.setLastName(ebm.getlName());
        employee.setAge(ebm.getAge());
        employee.setGender(ebm.getGender());

        //set this employee as manager for all received buildings list
        for (Building b :
                buildings) {
            b.setManager(employee);
        }

        //remove this employee as manager for buildings that are not part of the received buildings list
        for (Building building :
                employee.getManagedBuildings()) {
            if(!buildings.contains(building)) {
                building.setManager(null);
            }
        }
        
        this.employeeRepository.saveAndFlush(employee);
    }
}
