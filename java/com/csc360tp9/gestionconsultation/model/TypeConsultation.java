package com.csc360tp9.gestionconsultation.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name="typeConsultation")
public class TypeConsultation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="type_consultation",nullable=false)
	private String typeConsultation;
	
	@Column(name="description",nullable=false)
	private String description;
	
	/*Ajout de la relation OneToOne entre Consultation et typeConsulation*/
	@OneToOne(mappedBy = "type_consultation",fetch = FetchType.LAZY)
	private Set<Consultation> consultations;
	
	
	public TypeConsultation() {
		super();
	}

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTypeConsultation() {
		return typeConsultation;
	}
	public void setTypeConsultation(String typeConsultation) {
		this.typeConsultation = typeConsultation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public TypeConsultation(Long id, String typeConsultation, String description) {
		super();
		this.id = id;
		this.typeConsultation = typeConsultation;
		this.description = description;
	}
	
	
	@Override
	public String toString() {
		return "TypeConsultation [id=" + id + ", typeConsultation=" + typeConsultation + ", description=" + description
				+ ", consultations=" + consultations + "]";
	}


	public Set<Consultation> getConsultations() {
		return consultations;
	}


	public void setConsultations(Set<Consultation> consultations) {
		this.consultations = consultations;
	}

}
