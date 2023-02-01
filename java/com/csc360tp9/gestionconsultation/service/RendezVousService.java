package com.csc360tp9.gestionconsultation.service;

import java.util.List;

import com.csc360tp9.gestionconsultation.model.RendezVous;

public interface RendezVousService {
	
    public List<RendezVous> getAll();

    public RendezVous findById(Long id);

    public RendezVous save(RendezVous rendezVous);

    public RendezVous update(RendezVous rendezVous);

    public void deleteById(Long id);

}
