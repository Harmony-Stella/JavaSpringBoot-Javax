package com.csc360tp9.gestionconsultation.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;



@Entity
@DiscriminatorValue("Medecin")
@Table(name="medecin")
public class Medecin extends Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="specialite",nullable=false)
	private String specialite;
	
	/*Ajout de la relation OneToOne entre medecin et Consultation*/
	@OneToOne(mappedBy = "mededcin",fetch = FetchType.LAZY)
	private Set<Consultation> consultations;
	
	/*Ajout de la relation ManyToOne entre medecin et typeconsultation*/
    @ManyToOne()
    @JoinColumn(name = "type_consulation_id")
    private TypeConsultation typeConsultation;
    
	/*Ajout de la relation OneToOne entre medecin et consultation*/
    @OneToOne()
    @JoinColumn(name = "consultation_id")
    private Consultation consultation;
    
    
	public Medecin() {
		super();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public Set<Consultation> getConsultations() {
		return consultations;
	}

	public void setConsultations(Set<Consultation> consultations) {
		this.consultations = consultations;
	}


	
	public Medecin(Long id, String nom, String prenom, Integer numeroTelephone, String adresse, String specialite) {
		super(id,nom,prenom,numeroTelephone,adresse,specialite);

	}
	
	@Override
	public String toString() {
		return "Medecin [id=" + id + ", specialite=" + specialite + ", consultations=" + consultations + ", consultation=" + consultation + "]";
	}

	public Consultation getConsultation() {
		return consultation;
	}

	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}


}
