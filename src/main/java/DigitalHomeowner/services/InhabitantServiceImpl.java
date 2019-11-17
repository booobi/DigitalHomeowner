package DigitalHomeowner.services;

import DigitalHomeowner.bindingModels.InhabitantBindingModel;
import DigitalHomeowner.entities.Inhabitant;
import DigitalHomeowner.repositories.InhabitantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InhabitantServiceImpl extends InhabitantService {

    @Autowired
    private InhabitantRepository inhabitantRepository;

    @Override
    public void edit(String id, InhabitantBindingModel ibm) {
        Inhabitant inhabitant = this.inhabitantRepository.getOne(id);
        inhabitant.setName(ibm.getName());

        this.inhabitantRepository.saveAndFlush(inhabitant);
    }

    @Override
    public void delete(String id) {
        this.inhabitantRepository.deleteById(id);
    }

    public Inhabitant getById(String id) {
        return this.inhabitantRepository.getOne(id);
    }
}
