package com.upf.resto.datamodel;

import java.awt.image.BufferedImage;
import java.util.Date;

public class Personne {
	String nom;
	String prenom;
	Date dateDeNaissance;
	String sexe;
	String email;
	BufferedImage imageP;
	
	public Personne(String nom, String prenom, Date dateDeNaissance, String sexe, String email) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.sexe = sexe;
		this.email = email;
	}

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

	public BufferedImage getImageP() {
		return imageP;
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

	public void setImageP(BufferedImage imageP) {
		this.imageP = imageP;
	}
	
	
	
	
}
