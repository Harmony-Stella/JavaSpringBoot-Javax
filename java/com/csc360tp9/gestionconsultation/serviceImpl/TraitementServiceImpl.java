package com.csc360tp9.gestionconsultation.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csc360tp9.gestionconsultation.model.Traitement;
import com.csc360tp9.gestionconsultation.repository.TraitementRepository;
import com.csc360tp9.gestionconsultation.service.TraitementService;

@Service
public class TraitementServiceImpl implements TraitementService {
	
	@Autowired
	public TraitementRepository traitementRepository;
	
    @Override
    public List<Traitement> getAll() {
        return this.traitementRepository.findAll();
    }

    @Override
    public Traitement findById(Long id) {
        return this.traitementRepository.findById(id).orElse(null);
    }

    @Override
    public Traitement save(Traitement traitement) {
        return this.traitementRepository.save(traitement);
    }

    @Override
    public Traitement update(Traitement traitement) {
        return this.traitementRepository.save(traitement);
    }

    @Override
    public void deleteById(Long id) {
        this.traitementRepository.deleteById(id);
    }

}
