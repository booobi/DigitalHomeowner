package DigitalHomeowner.controllers;

import DigitalHomeowner.bindingModels.BuildingBindingModel;
import DigitalHomeowner.bindingModels.PayementBindingModel;
import DigitalHomeowner.entities.Building;
import DigitalHomeowner.entities.Employee;
import DigitalHomeowner.entities.Inhabitant;
import DigitalHomeowner.services.BuildingService;
import DigitalHomeowner.services.EmployeeService;
import DigitalHomeowner.services.InhabitantService;
import DigitalHomeowner.services.PaymentEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BuildingsController {

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private InhabitantService inhabitantService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PaymentEntryService paymentEntryService;

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

    @GetMapping("/buildings/{id}/view")
    public String viewBuildngGet(@PathVariable("id") String id, Model model) {
        Building selectedBuilding = buildingService.getById(id);

        model.addAttribute("building", selectedBuilding);
        model.addAttribute("view", "buildings/view");

        return "base-layout";
    }

    @GetMapping("/buildings/{id}/pay")
    public String payBuildingGet(@PathVariable("id") String id, Model model) {
        Building selectedBuilding = buildingService.getById(id);
        List<Integer> nonPayedForMonths = this.paymentEntryService.getNonPayedMonthsList(selectedBuilding);

        model.addAttribute("nonPayedForMonths", nonPayedForMonths);
        model.addAttribute("building", selectedBuilding);
        model.addAttribute("view", "buildings/pay");

        return "base-layout";
    }

    @PostMapping("/buildings/{id}/pay")
    public String payBuildingPost(@PathVariable("id") String id, PayementBindingModel pbm) {
        Building selectedBuilding = buildingService.getById(id);

        paymentEntryService.create(pbm, selectedBuilding);

        return "redirect:/";
    }

    @PostMapping("/buildings/{id}/delete")
    public String deleteBuildingPost(@PathVariable("id") String id) {

        Building buildingToDelete = this.buildingService.getById(id);

        for (Inhabitant inhabitantToDelete :
                buildingToDelete.getInhabitants()) {
            this.inhabitantService.delete(inhabitantToDelete.getId());
        }

        if(buildingToDelete.getManager() != null) {
            this.employeeService.removeManagedBuilding(buildingToDelete.getManager(), buildingToDelete);
        }

        this.buildingService.delete(buildingToDelete);

        return "redirect:/";
    }
}
