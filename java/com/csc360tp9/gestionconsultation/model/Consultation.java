package com.csc360tp9.gestionconsultation.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.Id;

@Entity
@Table(name="consultation")
public class Consultation {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="dateConsulation",nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateConsultation;
	
	@Column(name="motif",nullable=false)
	private String motif;
	
	@Column(name="description",nullable=false)
	private String description;
	
	@Column(name="prix",nullable=false)
	private Double prix;
	
	@Column(name="nom_medecin",nullable=false)
	private String nomMedecin;
	
	@Column(name="nom_patient",nullable=false)
	private String nomPatient;
	
	/*Ajout de la relation OneToOne entre consultation et patient*/
    @OneToOne()
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;
    
	/*Ajout de la relation OneToOne entre consultation et medecin*/
    @OneToOne()
    @JoinColumn(name = "medecin_id",referencedColumnName = "id")
    private Medecin medecin;
    
	public Consultation() {
		super();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateConsultation() {
		return dateConsultation;
	}
	public void setDateConsultation(Date dateConsultation) {
		this.dateConsultation = dateConsultation;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public String getNomMedecin() {
		return nomMedecin;
	}
	public void setNomMedecin(String nomMedecin) {
		this.nomMedecin = nomMedecin;
	}
	public String getNomPatient() {
		return nomPatient;
	}
	public void setNomPatient(String nomPatient) {
		this.nomPatient = nomPatient;
	}
	
	public Consultation(Long id, Date dateConsulation, String motif, String description, Double prix, String nomMedecin, String nomPatient)
	{
		super();
		this.id=id;
		this.dateConsultation=dateConsulation;
		this.motif=motif;
		this.description=description;
		this.prix=prix;
		this.nomMedecin=nomMedecin;
		this.nomPatient=nomPatient;
	}
	
	
	
	@Override
	public String toString() {
		return "Consultation [id=" + id + ", dateConsultation=" + dateConsultation + ", motif=" + motif
				+ ", description=" + description + ", prix=" + prix + ", nomMedecin=" + nomMedecin + ", nomPatient="
				+ nomPatient + ", patient=" + patient + ", medecin=" + medecin + "]";
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}


}