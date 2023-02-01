package com.csc360tp9.gestionconsultation.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name="traitement")
public class Traitement {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="prescription",nullable=false)
	private String prescription;
	
	@Column(name="description",nullable=false)
	private String description;
	
	/*Ajout de la relation OneToOne entre traitement et medecin*/
	@OneToMany(mappedBy = "traitement",fetch = FetchType.LAZY)
	private Set<Medecin> medecins;
	
	public Traitement() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPrescription() {
		return prescription;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Traitement(Long id, String prescription, String description) {
		super();
		this.id = id;
		this.prescription = prescription;
		this.description = description;
	}
	
	
	@Override
	public String toString() {
		return "Traitement [id=" + id + ", prescription=" + prescription + ", description=" + description + "]";
	}

}
