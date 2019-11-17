package DigitalHomeowner.services;

import DigitalHomeowner.bindingModels.EmployeeBindingModel;
import DigitalHomeowner.entities.Employee;

import java.util.List;

public abstract class EmployeeService {
    public abstract void create(EmployeeBindingModel ebm);
    public abstract void edit(String id, EmployeeBindingModel ebm);
    public abstract Employee getById(String id);
    public abstract List<Employee> getAll();
}
