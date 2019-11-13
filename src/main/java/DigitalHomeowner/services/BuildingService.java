package DigitalHomeowner.services;

import DigitalHomeowner.bindingModels.BuildingBindingModel;
import DigitalHomeowner.entities.Building;

import java.util.List;

public abstract class BuildingService {
    public abstract void create(BuildingBindingModel bbm);
    public abstract List<Building> getAll();
}
