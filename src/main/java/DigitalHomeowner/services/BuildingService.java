package DigitalHomeowner.services;

import DigitalHomeowner.bindingModels.BuildingBindingModel;
import DigitalHomeowner.entities.Building;

import java.util.List;

public abstract class BuildingService {
    public abstract void create(BuildingBindingModel bbm);
    public abstract void edit(String id, BuildingBindingModel bbm);
    public abstract List<Building> getAll();
    public abstract Building getById(String id);
}
