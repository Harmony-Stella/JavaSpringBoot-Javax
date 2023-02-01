package com.csc360tp9.gestionconsultation.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csc360tp9.gestionconsultation.model.RendezVous;
import com.csc360tp9.gestionconsultation.repository.RendezVousRepository;
import com.csc360tp9.gestionconsultation.service.RendezVousService;

@Service
public class RendezVousServiceImpl implements RendezVousService{
	@Autowired
	public RendezVousRepository rendezVousRepository;
	
    @Override
    public List<RendezVous> getAll() {
        return this.rendezVousRepository.findAll();
    }

    @Override
    public RendezVous findById(Long id) {
        return this.rendezVousRepository.findById(id).orElse(null);
    }

    @Override
    public RendezVous save(RendezVous rendezVous) {
        return this.rendezVousRepository.save(rendezVous);
    }

    @Override
    public RendezVous update(RendezVous rendezVous) {
        return this.rendezVousRepository.save(rendezVous);
    }

    @Override
    public void deleteById(Long id) {
        this.rendezVousRepository.deleteById(id);
    }

}
