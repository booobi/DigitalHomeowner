package DigitalHomeowner.controllers;

import DigitalHomeowner.bindingModels.InhabitantBindingModel;
import DigitalHomeowner.entities.Inhabitant;
import DigitalHomeowner.services.InhabitantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InhabitantsController {

    @Autowired
    private InhabitantService inhabitantService;

    @GetMapping("/inhabitants/{id}/edit")
    public String editInhabitantGet(@PathVariable("id") String id, Model model) {

        Inhabitant inhabitant = this.inhabitantService.getById(id);

        model.addAttribute("inhabitant", inhabitant);
        model.addAttribute("view", "inhabitants/edit");

        return "base-layout";
    }

    @PostMapping("/inhabitants/{id}/edit")
    public String editInhabitantPost(@PathVariable("id") String id, InhabitantBindingModel ibm, Model model) {
        this.inhabitantService.edit(id, ibm);

        model.addAttribute("editSuccess", true);
        model.addAttribute("view", "inhabitants/edit");

        return "base-layout";
    }
}
