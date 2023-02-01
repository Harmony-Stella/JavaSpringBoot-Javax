package com.csc360tp9.gestionconsultation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csc360tp9.gestionconsultation.model.Patient;
import com.csc360tp9.gestionconsultation.service.PatientService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PatientController {
	
	@Autowired
	public PatientService patientService;
	
	@RequestMapping(value = "/patients", method = RequestMethod.GET)
    public List<Patient> getAllPatienti() {

        List<Patient> patients = new ArrayList<>();

        try {
            patients = this.patientService.getAll();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erreur " + e.getMessage());
        }

        return patients;

    }

    @RequestMapping(value = "/patient/{id}", method = RequestMethod.GET)
    public Patient getOnePatient(@PathVariable Long id) {

        Patient patient = new Patient();

        try {
            patient = this.patientService.findById(id);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return patient;
    }

    @RequestMapping(value = "/patient/ajouter", method = RequestMethod.POST, headers = "accept=Application/json")
    public Patient savePatient(@RequestBody Patient patient) {

        try {
            patient = this.patientService.save(patient);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return patient;
    }

    @RequestMapping(value = "/patient/modifier/{id}", method = RequestMethod.PUT, headers = "accept=Application/json")
    public Patient updatePatient(@RequestBody Patient patient, @PathVariable  int id) {

        try {
            patient = this.patientService.update(patient);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return patient;

    }

    @RequestMapping(value = "/patient/supprimer/{id}", method = RequestMethod.DELETE, headers = "accept=Application/json")
    public void deletePatient(@PathVariable Long id) {
        this.patientService.deleteById(id);
    }

}
