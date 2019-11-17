package DigitalHomeowner.controllers;

import DigitalHomeowner.bindingModels.EmployeeBindingModel;
import DigitalHomeowner.entities.Employee;
import DigitalHomeowner.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeesController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public String employeesGet(Model model) {

        List<Employee> employees = this.employeeService.getAll();

        model.addAttribute("employees", employees);
        model.addAttribute("view", "employees/index");

        return "base-layout";
    }

    @GetMapping("/employees/create")
    public String createEmployeeGet(Model model) {
        model.addAttribute("view", "employees/create");

        return "base-layout";
    }

    @PostMapping("/employees/create")
    public String createEmployeePost(EmployeeBindingModel ebm, Model model) {
        this.employeeService.create(ebm);

        model.addAttribute("createSuccess", true);
        model.addAttribute("view", "employees/create");

        return "base-layout";
    }

    @GetMapping("/employees/{id}/edit")
    public String editEmployeeGet(@PathVariable("id") String id, Model model) {
        Employee employee = this.employeeService.getById(id);

        model.addAttribute("employee", employee);
        model.addAttribute("view", "employees/edit");

        return "base-layout";
    }

    @PostMapping("/employees/{id}/edit")
    public String editEmployeePost(@PathVariable("id") String id ,EmployeeBindingModel ebm, Model model) {
        this.employeeService.edit(id, ebm);

        model.addAttribute("editSuccess", true);
        model.addAttribute("view", "employees/edit");

        return "base-layout";
    }
}
