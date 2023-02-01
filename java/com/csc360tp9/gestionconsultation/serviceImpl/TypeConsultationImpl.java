package com.csc360tp9.gestionconsultation.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csc360tp9.gestionconsultation.model.TypeConsultation;
import com.csc360tp9.gestionconsultation.repository.TypeConsultationRepository;
import com.csc360tp9.gestionconsultation.service.TypeConsultationService;

@Service
public class TypeConsultationImpl implements TypeConsultationService {
	
	@Autowired
	public TypeConsultationRepository typeConsultationRepository;
	
    @Override
    public List<TypeConsultation> getAll() {
        return this.typeConsultationRepository.findAll();
    }

    @Override
    public TypeConsultation findById(Long id) {
        return this.typeConsultationRepository.findById(id).orElse(null);
    }

    @Override
    public TypeConsultation save(TypeConsultation typeConsultation) {
        return this.typeConsultationRepository.save(typeConsultation);
    }

    @Override
    public TypeConsultation update(TypeConsultation typeConsultation) {
        return this.typeConsultationRepository.save(typeConsultation);
    }

    @Override
    public void deleteById(Long id) {
        this.typeConsultationRepository.deleteById(id);
    }

}
