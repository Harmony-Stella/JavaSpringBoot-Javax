package com.csc360tp9.gestionconsultation.service;

import java.util.List;
import com.csc360tp9.gestionconsultation.model.TypeConsultation;

public interface TypeConsultationService {
	
    public List<TypeConsultation> getAll();

    public TypeConsultation findById(Long id);

    public TypeConsultation save(TypeConsultation typeConsultation);

    public TypeConsultation update(TypeConsultation typeConsultation);

    public void deleteById(Long id);

}
