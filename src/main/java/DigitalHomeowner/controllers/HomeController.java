package DigitalHomeowner.controllers;

import DigitalHomeowner.entities.Building;
import DigitalHomeowner.services.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    BuildingService buildingService;

    @RequestMapping("/")
    public String index() {
        return "redirect:/home";
    }

    @RequestMapping("/home")
    public String home(Model model) {

        List<Building> buildings = this.buildingService.getAll();

        model.addAttribute("view", "home");
        model.addAttribute("buildings", buildings);
        return "base-layout";
    }

}
