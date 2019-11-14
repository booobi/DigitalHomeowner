package DigitalHomeowner.controllers;

import DigitalHomeowner.bindingModels.BuildingBindingModel;
import DigitalHomeowner.entities.Building;
import DigitalHomeowner.services.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BuildingsController {

    @Autowired
    private BuildingService buildingService;

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

    @GetMapping("/buildings/{id}/edit")
    public String editBuildngGet(@PathVariable("id") String id, Model model) {
        Building selectedBuilding = buildingService.getById(id);

        model.addAttribute("building", selectedBuilding);
        model.addAttribute("view", "buildings/edit");

        return "base-layout";
    }

    @PostMapping("/buildings/{id}/edit")
    public String editBuildingPost(@PathVariable("id") String id, BuildingBindingModel buildingBindingModel, Model model) {

        this.buildingService.edit(id, buildingBindingModel);

        model.addAttribute("createSuccess", true);
        model.addAttribute("view", "buildings/edit");
        return "base-layout";
    }
}
