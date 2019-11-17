package DigitalHomeowner.controllers;

import DigitalHomeowner.bindingModels.EmployeeBindingModel;
import DigitalHomeowner.entities.Building;
import DigitalHomeowner.entities.Employee;
import DigitalHomeowner.services.BuildingService;
import DigitalHomeowner.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class EmployeesController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private BuildingService buildingService;

    @GetMapping("/employees")
    public String employeesGet(Model model) {

        List<Employee> employees = this.employeeService.getAll();

        model.addAttribute("employees", employees);
        model.addAttribute("view", "employees/index");

        return "base-layout";
    }

    @GetMapping("/employees/create")
    public String createEmployeeGet(Model model) {
        List<Building> buildings = this.buildingService.getAll();

        model.addAttribute("buildings", buildings);
        model.addAttribute("view", "employees/create");

        return "base-layout";
    }

    @PostMapping("/employees/create")
    public String createEmployeePost(EmployeeBindingModel ebm, Model model) {
        if(ebm.getBuildingIdsToManage() == null) ebm.setBuildingIdsToManage(new ArrayList<>());

        Set<Building> buildingsToManage = this.buildingService
                .getAll()
                .stream()
                .filter((building -> ebm.getBuildingIdsToManage().contains(building.getId())))
                .collect(Collectors.toSet());

        this.employeeService.create(ebm, buildingsToManage);

        model.addAttribute("createSuccess", true);
        model.addAttribute("view", "employees/create");

        return "base-layout";
    }

    @GetMapping("/employees/{id}/edit")
    public String editEmployeeGet(@PathVariable("id") String id, Model model) {

        Employee employee = this.employeeService.getById(id);
        List<Building> buildings = this.buildingService.getAll();

        model.addAttribute("buildings", buildings);
        model.addAttribute("employee", employee);
        model.addAttribute("view", "employees/edit");

        return "base-layout";
    }

    @PostMapping("/employees/{id}/edit")
    public String editEmployeePost(@PathVariable("id") String id ,EmployeeBindingModel ebm, Model model) {

        if(ebm.getBuildingIdsToManage() == null) ebm.setBuildingIdsToManage(new ArrayList<>());
        Set<Building> buildingsToManage = this.buildingService
                .getAll()
                .stream()
                .filter((building -> ebm.getBuildingIdsToManage().contains(building.getId())))
                .collect(Collectors.toSet());

        this.employeeService.edit(id, ebm, buildingsToManage);

        model.addAttribute("editSuccess", true);
        model.addAttribute("view", "employees/edit");

        return "base-layout";
    }

    @PostMapping("/employees/{id}/delete")
    public String deleteEmployeePost(@PathVariable("id") String id) {
        Employee employeeToDelete = this.employeeService.getById(id);

        for (Building managedBuilding :
                employeeToDelete.getManagedBuildings()) {
            this.buildingService.removeManager(managedBuilding.getId());
        }

        this.employeeService.deleteById(id);

        return "redirect:/employees";
    }
}
