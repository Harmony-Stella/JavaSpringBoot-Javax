package com.csc360tp9.gestionconsultation.service;

import java.util.List;

import com.csc360tp9.gestionconsultation.model.Traitement;

public interface TraitementService {
	
    public List<Traitement> getAll();

    public Traitement findById(Long id);

    public Traitement save(Traitement traitement);

    public Traitement update(Traitement traitement);

    public void deleteById(Long id);

}
