package com.csc360tp9.gestionconsultation.service;

import java.util.List;

import com.csc360tp9.gestionconsultation.model.Consultation;

public interface ConsultationService {
	
    public List<Consultation> getAll();

    public Consultation findById(Long id);

    public Consultation save(Consultation consultation);

    public Consultation update(Consultation consultation);

    public void deleteById(Long id);

}
