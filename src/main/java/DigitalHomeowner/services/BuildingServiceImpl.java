package DigitalHomeowner.services;

import DigitalHomeowner.bindingModels.BuildingBindingModel;
import DigitalHomeowner.entities.Building;
import DigitalHomeowner.repositories.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingServiceImpl extends BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Override
    public void create(BuildingBindingModel bbm) {
        Building newBuilding = new Building(
                bbm.address,
                bbm.floors,
                bbm.apartments,
                bbm.buildingArea,
                bbm.commonArea,
                null

        );
        buildingRepository.saveAndFlush(newBuilding);
    }

    @Override
    public List<Building> getAll() {
        return buildingRepository.findAll();
    }
}
