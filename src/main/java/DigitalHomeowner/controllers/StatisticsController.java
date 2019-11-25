package DigitalHomeowner.controllers;

import DigitalHomeowner.entities.Building;
import DigitalHomeowner.entities.Employee;
import DigitalHomeowner.entities.PaymentEntry;
import DigitalHomeowner.services.BuildingService;
import DigitalHomeowner.services.EmployeeService;
import DigitalHomeowner.services.PaymentEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StatisticsController {


    @Autowired
    private BuildingService buildingService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PaymentEntryService paymentEntryService;

    @RequestMapping("/statistics")
    public String statistics(Model model) {
        List<Building> allBuildings = this.buildingService.getAll();
        List<Employee> allEmployees = this.employeeService.getAll();
        List<PaymentEntry> allPayments = this.paymentEntryService.getAll();

        Integer apartmentCount = allBuildings.size() == 0 ? 0: allBuildings.stream()
                .map(building -> building.getApartments())
                .reduce((apts1,apts2) -> apts1 + apts2)
                .get();

        Integer inhabitantCount = allBuildings.size() == 0 ? 0 :allBuildings.stream()
                .map(building -> building.getInhabitants().size())
                .reduce((inh1, inh2) -> inh1 + inh2)
                .get();

        Double monthlyIncome = allBuildings.size() == 0 ? 0.0 : allBuildings.stream()
                .map(building -> building.getAmountToPay())
                .reduce((val1, val2) -> val1 + val2)
                .get();

        Double currentBalance = allPayments.size() == 0 ? 0.0 : allPayments.stream()
                .map(paymentEntry -> paymentEntry.getAmountPayed())
                .reduce((val1, val2) -> val1 + val2)
                .get();

        model.addAttribute("buildings", allBuildings);
        model.addAttribute("employees", allEmployees);
        model.addAttribute("payments", allPayments);
        model.addAttribute("apartmentCount", apartmentCount);
        model.addAttribute("inhabitantCount", inhabitantCount);
        model.addAttribute("income", monthlyIncome);
        model.addAttribute("balance", currentBalance);

        model.addAttribute("view", "statistics");

        return "base-layout";

    }
}
