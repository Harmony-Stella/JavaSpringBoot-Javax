package com.csc360tp9.gestionconsultation.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csc360tp9.gestionconsultation.model.Medecin;
import com.csc360tp9.gestionconsultation.repository.MedecinRepository;
import com.csc360tp9.gestionconsultation.service.MedecinService;


@Service
public class MedecinServiceImpl  implements MedecinService{
	
	@Autowired
	public MedecinRepository medecinRepository;
	
    @Override
    public List<Medecin> getAll() {
        return this.medecinRepository.findAll();
    }

    @Override
    public Medecin findById(Long id) {
        return this.medecinRepository.findById(id).orElse(null);
    }

    @Override
    public Medecin save(Medecin medecin) {
        return this.medecinRepository.save(medecin);
    }

    @Override
    public Medecin update(Medecin medecin) {
        return this.medecinRepository.save(medecin);
    }

    @Override
    public void deleteById(Long id) {
        this.medecinRepository.deleteById(id);
    }

}
