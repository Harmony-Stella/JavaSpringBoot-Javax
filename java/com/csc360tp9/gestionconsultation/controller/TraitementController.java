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

import com.csc360tp9.gestionconsultation.model.Traitement;
import com.csc360tp9.gestionconsultation.service.TraitementService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class TraitementController {
	
	@Autowired
	public TraitementService traitementService;
	
	@RequestMapping(value = "/traitements", method = RequestMethod.GET)
    public List<Traitement> getAllTraitementi() {

        List<Traitement> traitements = new ArrayList<>();

        try {
            traitements = this.traitementService.getAll();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erreur " + e.getMessage());
        }

        return traitements;

    }

    @RequestMapping(value = "/traitement/{id}", method = RequestMethod.GET)
    public Traitement getOneTraitement(@PathVariable Long id) {

        Traitement traitement = new Traitement();

        try {
            traitement = this.traitementService.findById(id);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return traitement;
    }

    @RequestMapping(value = "/traitement/ajouter", method = RequestMethod.POST, headers = "accept=Application/json")
    public Traitement saveTraitement(@RequestBody Traitement traitement) {

        try {
            traitement = this.traitementService.save(traitement);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return traitement;
    }

    @RequestMapping(value = "/traitement/modifier/{id}", method = RequestMethod.PUT, headers = "accept=Application/json")
    public Traitement updateTraitement(@RequestBody Traitement traitement, @PathVariable  int id) {

        try {
            traitement = this.traitementService.update(traitement);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return traitement;

    }

    @RequestMapping(value = "/traitement/supprimer/{id}", method = RequestMethod.DELETE, headers = "accept=Application/json")
    public void deleteTraitement(@PathVariable Long id) {
        this.traitementService.deleteById(id);
    }

}
