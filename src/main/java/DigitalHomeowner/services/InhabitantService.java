package DigitalHomeowner.services;

import DigitalHomeowner.bindingModels.InhabitantBindingModel;
import DigitalHomeowner.entities.Inhabitant;

public abstract class InhabitantService {
    public abstract void edit(String id, InhabitantBindingModel ibm);
    public abstract void delete(String id);
    public abstract Inhabitant getById(String id);
}
