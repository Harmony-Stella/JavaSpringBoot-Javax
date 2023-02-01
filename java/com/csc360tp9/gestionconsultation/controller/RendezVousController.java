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

import com.csc360tp9.gestionconsultation.model.RendezVous;
import com.csc360tp9.gestionconsultation.service.RendezVousService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class RendezVousController {
	
	@Autowired
	public RendezVousService rendezVousService;
	
	@RequestMapping(value = "/rendezVouss", method = RequestMethod.GET)
    public List<RendezVous> getAllRendezVousi() {

        List<RendezVous> rendezVouss = new ArrayList<>();

        try {
            rendezVouss = this.rendezVousService.getAll();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erreur " + e.getMessage());
        }

        return rendezVouss;

    }

    @RequestMapping(value = "/rendezVous/{id}", method = RequestMethod.GET)
    public RendezVous getOneRendezVous(@PathVariable Long id) {

        RendezVous rendezVous = new RendezVous();

        try {
            rendezVous = this.rendezVousService.findById(id);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return rendezVous;
    }

    @RequestMapping(value = "/rendezVous/ajouter", method = RequestMethod.POST, headers = "accept=Application/json")
    public RendezVous saveRendezVous(@RequestBody RendezVous rendezVous) {

        try {
            rendezVous = this.rendezVousService.save(rendezVous);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return rendezVous;
    }

    @RequestMapping(value = "/rendezVous/modifier/{id}", method = RequestMethod.PUT, headers = "accept=Application/json")
    public RendezVous updateRendezVous(@RequestBody RendezVous rendezVous, @PathVariable  int id) {

        try {
            rendezVous = this.rendezVousService.update(rendezVous);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return rendezVous;

    }

    @RequestMapping(value = "/rendezVous/supprimer/{id}", method = RequestMethod.DELETE, headers = "accept=Application/json")
    public void deleteRendezVous(@PathVariable Long id) {
        this.rendezVousService.deleteById(id);
    }

}
