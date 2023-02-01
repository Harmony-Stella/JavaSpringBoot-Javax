package com.csc360tp9.gestionconsultation.service;

import java.util.List;

import com.csc360tp9.gestionconsultation.model.Medecin;

public interface MedecinService {
	
    public List<Medecin> getAll();

    public Medecin findById(Long id);

    public Medecin save(Medecin medecin);

    public Medecin update(Medecin medecin);

    public void deleteById(Long id);

}
