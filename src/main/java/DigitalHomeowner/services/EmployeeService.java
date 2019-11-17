package DigitalHomeowner.services;

import DigitalHomeowner.bindingModels.EmployeeBindingModel;
import DigitalHomeowner.entities.Building;
import DigitalHomeowner.entities.Employee;

import java.util.List;
import java.util.Set;

public abstract class EmployeeService {
    public abstract void create(EmployeeBindingModel ebm, Set<Building> buildings);
    public abstract void edit(String id, EmployeeBindingModel ebm, Set<Building> buildings);
    public abstract void deleteById(String id);
    public abstract Employee getById(String id);
    public abstract List<Employee> getAll();
}
