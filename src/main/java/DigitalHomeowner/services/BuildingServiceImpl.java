package DigitalHomeowner.services;

import DigitalHomeowner.bindingModels.BuildingBindingModel;
import DigitalHomeowner.entities.Building;
import DigitalHomeowner.entities.Inhabitant;
import DigitalHomeowner.repositories.BuildingRepository;
import DigitalHomeowner.repositories.InhabitantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuildingServiceImpl extends BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private InhabitantRepository inhabitantRepository;

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

        //convert string names to Inhabitant object list
        List<String> inhabitantsStrings = bbm.getInhabitants();
        List<Inhabitant> inhabitantsToSave = new ArrayList<>();
        if(inhabitantsStrings != null) {
            inhabitantsToSave = bbm.getInhabitants()
                    .stream()
                    .filter((inhName) -> inhName != null)
                    .filter((inhName) -> !inhName.equals(""))
                    .map((inhName) -> new Inhabitant(inhName, newBuilding))
                    .collect(Collectors.toList());

        }

        buildingRepository.saveAndFlush(newBuilding);
        inhabitantRepository.saveAll(inhabitantsToSave);


    }

    @Override
    public List<Building> getAll() {
        return buildingRepository.findAll();
    }
}
