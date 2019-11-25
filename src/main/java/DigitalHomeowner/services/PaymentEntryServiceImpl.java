package DigitalHomeowner.services;

import DigitalHomeowner.bindingModels.PayementBindingModel;
import DigitalHomeowner.entities.Building;
import DigitalHomeowner.entities.PaymentEntry;
import DigitalHomeowner.repositories.PaymentEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentEntryServiceImpl extends PaymentEntryService {

    @Autowired
    private PaymentEntryRepository paymentEntryRepository;

    @Override
    public List<PaymentEntry> getAll() {
        return this.paymentEntryRepository.findAll();
    }

    @Override
    public void create(PayementBindingModel pbm, Building building) {
        PaymentEntry paymentEntry = new PaymentEntry(building, building.getAmountToPay(), new java.sql.Date(new Date().getTime()), pbm.getMonth());
        this.paymentEntryRepository.saveAndFlush(paymentEntry);
    }

    @Override
    public List<Integer> getNonPayedMonthsList(Building building) {
        List<Integer> allMonths = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12));
        List<Integer> unavailableMonths = this.paymentEntryRepository.getAllByBuilding(building)
                .stream()
                .map(paymentEntry -> paymentEntry.getMonthForPayed())
                .collect(Collectors.toList());

        List<Integer> availableMonths =
                allMonths.stream()
                    .filter(availableMonth -> !unavailableMonths.contains(availableMonth))
                    .collect(Collectors.toList());

        return availableMonths;
    }
}
