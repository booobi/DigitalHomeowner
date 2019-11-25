package DigitalHomeowner.services;

import DigitalHomeowner.bindingModels.PayementBindingModel;
import DigitalHomeowner.entities.Building;

import java.util.List;

public abstract class PaymentEntryService {
    public abstract void create(PayementBindingModel pbm, Building building);
    public abstract List<Integer> getNonPayedMonthsList(Building building);
}
