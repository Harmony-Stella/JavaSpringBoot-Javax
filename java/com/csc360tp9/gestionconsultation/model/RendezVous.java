package com.csc360tp9.gestionconsultation.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.Id;

@Entity
@Table(name="rendezVous")
public class RendezVous {




	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="medecin", nullable=false)
	private Medecin medecin;
	
	@Column(name="date_rendez_vous", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateRendezVous;
	
	@Column(name="service", nullable=false)
	private String Service;
	
	
	public RendezVous() {
		super();
	}
	
	/*Ajout de la relation OneToOne entre rendez vous et patient*/
	@OneToOne(mappedBy = "rendez_vous",fetch = FetchType.LAZY)
	private Set<Patient> patients;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Medecin getMedecin() {
		return medecin;
	}
	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}
	public Date getDateRendezVous() {
		return dateRendezVous;
	}
	public void setDateRendezVous(Date dateRendezVous) {
		this.dateRendezVous = dateRendezVous;
	}
	public String getService() {
		return Service;
	}
	public void setService(String service) {
		Service = service;
	}
	
	public RendezVous(Long id, Medecin medecin, Date dateRendezVous, String service) {
		super();
		this.id = id;
		this.medecin = medecin;
		this.dateRendezVous = dateRendezVous;
		Service = service;
	}
	
	
	@Override
	public String toString() {
		return "RendezVous [id=" + id + ", medecin=" + medecin + ", dateRendezVous=" + dateRendezVous + ", Service="
				+ Service + "]";
	}

}
