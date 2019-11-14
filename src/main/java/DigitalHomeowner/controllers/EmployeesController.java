package DigitalHomeowner.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeesController {

    @GetMapping("/employees")
    public String employeesGet(Model model) {
        model.addAttribute("view", "employees/index");

        return "base-layout";
    }
}
