package DigitalHomeowner.controllers;

import DigitalHomeowner.bindingModels.BuildingBindingModel;
import DigitalHomeowner.entities.Building;
import DigitalHomeowner.repositories.BuildingRepository;
import DigitalHomeowner.services.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BuildingsController {

    @Autowired
    private BuildingService buildingService;

    @GetMapping("/buildings")
    public String index(Model model) {

        List<Building> allBuildings = buildingService.getAll();

        model.addAttribute("buildings", allBuildings);
        model.addAttribute("view", "buildings/index");

        return "base-layout";
    }


    @GetMapping("/buildings/create")
    public String createBuildingGet(Model model) {
        model.addAttribute("view", "buildings/create");
        return "base-layout";
    }

    @PostMapping("/buildings/create")
    public String createBuildingPost(BuildingBindingModel buildingBindingModel, Model model) {
        buildingService.create(buildingBindingModel);
        model.addAttribute("createSuccess", true);
        model.addAttribute("view", "buildings/create");
        return "base-layout";
    }
}
