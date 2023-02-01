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

import com.csc360tp9.gestionconsultation.model.Medecin;
import com.csc360tp9.gestionconsultation.service.MedecinService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class MedecinController {
	
	@Autowired
	public MedecinService medecinService;
	
	@RequestMapping(value = "/medecins", method = RequestMethod.GET)
    public List<Medecin> getAllMedecini() {

        List<Medecin> medecins = new ArrayList<>();

        try {
            medecins = this.medecinService.getAll();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erreur " + e.getMessage());
        }

        return medecins;

    }

    @RequestMapping(value = "/medecin/{id}", method = RequestMethod.GET)
    public Medecin getOneMedecin(@PathVariable Long id) {

        Medecin medecin = new Medecin();

        try {
            medecin = this.medecinService.findById(id);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return medecin;
    }

    @RequestMapping(value = "/medecin/ajouter", method = RequestMethod.POST, headers = "accept=Application/json")
    public Medecin saveMedecin(@RequestBody Medecin medecin) {

        try {
            medecin = this.medecinService.save(medecin);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return medecin;
    }

    @RequestMapping(value = "/medecin/modifier/{id}", method = RequestMethod.PUT, headers = "accept=Application/json")
    public Medecin updateMedecin(@RequestBody Medecin medecin, @PathVariable  int id) {

        try {
            medecin = this.medecinService.update(medecin);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return medecin;

    }

    @RequestMapping(value = "/medecin/supprimer/{id}", method = RequestMethod.DELETE, headers = "accept=Application/json")
    public void deleteMedecin(@PathVariable Long id) {
        this.medecinService.deleteById(id);
    }
	
	

}
