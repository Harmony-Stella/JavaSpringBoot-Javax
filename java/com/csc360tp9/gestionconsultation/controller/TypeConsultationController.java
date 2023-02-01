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

import com.csc360tp9.gestionconsultation.model.TypeConsultation;
import com.csc360tp9.gestionconsultation.service.TypeConsultationService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class TypeConsultationController {
	
	@Autowired
	public TypeConsultationService typeConsultationService;
	
	@RequestMapping(value = "/typeConsultations", method = RequestMethod.GET)
    public List<TypeConsultation> getAllTypeConsultationi() {

        List<TypeConsultation> typeConsultations = new ArrayList<>();

        try {
            typeConsultations = this.typeConsultationService.getAll();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erreur " + e.getMessage());
        }

        return typeConsultations;

    }

    @RequestMapping(value = "/typeConsultation/{id}", method = RequestMethod.GET)
    public TypeConsultation getOneTypeConsultation(@PathVariable Long id) {

        TypeConsultation typeConsultation = new TypeConsultation();

        try {
            typeConsultation = this.typeConsultationService.findById(id);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return typeConsultation;
    }

    @RequestMapping(value = "/typeConsultation/ajouter", method = RequestMethod.POST, headers = "accept=Application/json")
    public TypeConsultation saveTypeConsultation(@RequestBody TypeConsultation typeConsultation) {

        try {
            typeConsultation = this.typeConsultationService.save(typeConsultation);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return typeConsultation;
    }

    @RequestMapping(value = "/typeConsultation/modifier/{id}", method = RequestMethod.PUT, headers = "accept=Application/json")
    public TypeConsultation updateTypeConsultation(@RequestBody TypeConsultation typeConsultation, @PathVariable  int id) {

        try {
            typeConsultation = this.typeConsultationService.update(typeConsultation);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return typeConsultation;

    }

    @RequestMapping(value = "/typeConsultation/supprimer/{id}", method = RequestMethod.DELETE, headers = "accept=Application/json")
    public void deleteTypeConsultation(@PathVariable Long id) {
        this.typeConsultationService.deleteById(id);
    }

}
