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
            inhabitantsToSave = this.getInhabitantsFromStringList(inhabitantsStrings, newBuilding);
        }

        buildingRepository.saveAndFlush(newBuilding);
        inhabitantRepository.saveAll(inhabitantsToSave);
    }

    @Override
    public void edit(String id, BuildingBindingModel bbm) {
        Building selectedBuilding = this.buildingRepository.getOne(id);
        selectedBuilding.setAddress(bbm.address);
        selectedBuilding.setFloors(bbm.floors);
        selectedBuilding.setApartments(bbm.apartments);
        selectedBuilding.setBuildArea(bbm.buildingArea);
        selectedBuilding.setCommonArea(bbm.commonArea);

        List<Inhabitant> newInhabitants = getInhabitantsFromStringList(bbm.getInhabitants(), selectedBuilding);
        selectedBuilding.addInhabitants(newInhabitants);

        this.buildingRepository.saveAndFlush(selectedBuilding);
        this.inhabitantRepository.saveAll(newInhabitants);
    }

    @Override
    public void delete(Building building) {
        this.buildingRepository.delete(building);
    }

    @Override
    public List<Building> getAll() {
        return buildingRepository.findAll();
    }

    @Override
    public Building getById(String id) {
        return this.buildingRepository.getOne(id);
    }

    private List<Inhabitant> getInhabitantsFromStringList(List<String> inhabitants, Building building) {
        if (inhabitants == null) return new ArrayList<>();
        return inhabitants
                .stream()
                .filter((inhName) -> inhName != null)
                .filter((inhName) -> !inhName.equals(""))
                .map((inhName) -> new Inhabitant(inhName, building))
                .collect(Collectors.toList());
    }

    @Override
    public void removeManager(String id) {
        Building building = this.buildingRepository.getOne(id);
        building.setManager(null);

        this.buildingRepository.saveAndFlush(building);
    }
}
