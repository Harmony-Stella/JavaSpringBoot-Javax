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

import com.csc360tp9.gestionconsultation.model.Consultation;
import com.csc360tp9.gestionconsultation.service.ConsultationService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ConsultationController {
	
	@Autowired
	public ConsultationService consultationService;
	
    @RequestMapping(value = "/consultations", method = RequestMethod.GET)
    public List<Consultation> getAllConsultations() {

        List<Consultation> consultations = new ArrayList<>();

        try {
            consultations = this.consultationService.getAll();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erreur " + e.getMessage());
        }

        return consultations;

    }
    
    @RequestMapping(value = "/consultation/{id}", method = RequestMethod.GET)
    public Consultation getOneConsultation(@PathVariable Long id) {

        Consultation consultation = new Consultation();

        try {
            consultation = this.consultationService.findById(id);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return consultation;
    }
    
    @RequestMapping(value = "/consultation/ajouter", method = RequestMethod.POST, headers = "accept=Application/json")
    public Consultation saveConsultation(@RequestBody Consultation consultation) {

        try {
            consultation = this.consultationService.save(consultation);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return consultation;
    }

    @RequestMapping(value = "/consultation/modifier/{id}", method = RequestMethod.PUT, headers = "accept=Application/json")
    public Consultation updateConsultation(@RequestBody Consultation consultation, @PathVariable  int id) {

        try {
            consultation = this.consultationService.update(consultation);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return consultation;

    }

    @RequestMapping(value = "/consultation/supprimer/{id}", method = RequestMethod.DELETE, headers = "accept=Application/json")
    public void deleteConsultation(@PathVariable Long id) {
        this.consultationService.deleteById(id);
    }

}
