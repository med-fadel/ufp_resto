package com.upf.resto.datamodel;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Personne {
	private String nom;
	private String prenom;
	private Date dateDeNaissance;
	private String sexe;
	private String email;

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public String getSexe() {
		return sexe;
	}

	public String getEmail() {
		return email;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
