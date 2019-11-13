package DigitalHomeowner.controllers;

import DigitalHomeowner.bindingModels.BuildingBindingModel;
import DigitalHomeowner.repositories.BuildingRepository;
import DigitalHomeowner.services.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String createBuildingPost(BuildingBindingModel buildingBindingModel) {
        buildingService.create(buildingBindingModel);

        return "redirect:/buildings/create";
    }
}
