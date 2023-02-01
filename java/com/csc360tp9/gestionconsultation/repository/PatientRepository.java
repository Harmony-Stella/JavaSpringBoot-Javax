package com.csc360tp9.gestionconsultation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csc360tp9.gestionconsultation.model.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long>{

}
