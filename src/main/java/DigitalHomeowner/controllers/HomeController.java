package DigitalHomeowner.controllers;

import DigitalHomeowner.entities.Building;
import DigitalHomeowner.entities.Employee;
import DigitalHomeowner.services.BuildingService;
import DigitalHomeowner.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private BuildingService buildingService;

    @RequestMapping("/")
    public String index() {
        return "redirect:/home";
    }

    @RequestMapping("/home")
    public String home(Model model) {

        List<Building> allBuildings = buildingService.getAll();

        model.addAttribute("buildings", allBuildings);
        model.addAttribute("view", "home");

        return "base-layout";
    }
}
