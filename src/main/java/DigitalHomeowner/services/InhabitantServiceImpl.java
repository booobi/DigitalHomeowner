package DigitalHomeowner.services;

import DigitalHomeowner.entities.Inhabitant;
import DigitalHomeowner.repositories.InhabitantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InhabitantServiceImpl extends InhabitantService {

    @Autowired
    private InhabitantRepository inhabitantRepository;

    public Inhabitant getById(String id) {
        return this.inhabitantRepository.getOne(id);
    }
}
