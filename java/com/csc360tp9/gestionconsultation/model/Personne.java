package com.csc360tp9.gestionconsultation.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name="Personne")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "utilisateur_type")
public class Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	protected Long id;
	
	@Column(name="nom",nullable=false)
	protected String nom;
	
	@Column(name="prenom",nullable=false)
	protected String prenom;
	
	@Column(name="numero_telephone",nullable=false)
	protected Integer numeroTelephone;
	
	@Column(name="adresse",nullable=false)
	protected String adresse;
	
	public Personne() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Integer getNumeroTelephone() {
		return numeroTelephone;
	}
	public void setNumeroTelephone(Integer numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public Personne(Long id, String nom, String prenom, Integer numeroTelephone, String adresse, String specialite) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.numeroTelephone = numeroTelephone;
		this.adresse = adresse;
	}
	
	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", numeroTelephone=" + numeroTelephone
				+ ", adresse=" + adresse + "]";
	}

}
