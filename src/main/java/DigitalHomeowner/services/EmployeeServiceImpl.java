package DigitalHomeowner.services;

import DigitalHomeowner.bindingModels.EmployeeBindingModel;
import DigitalHomeowner.entities.Employee;
import DigitalHomeowner.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl extends EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void create(EmployeeBindingModel ebm) {
        Employee newEmployee = new Employee(
                ebm.getfName(),
                ebm.getlName(),
                ebm.getAge(),
                ebm.getGender(),
                null
        );

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
    public void edit(String id, EmployeeBindingModel ebm) {
        Employee employee = this.employeeRepository.getOne(id);

        employee.setFirstName(ebm.getfName());
        employee.setLastName(ebm.getlName());
        employee.setAge(ebm.getAge());
        employee.setGender(ebm.getGender());

        this.employeeRepository.saveAndFlush(employee);
    }
}
