package com.upf.resto.datamodel;

import java.util.Date;

public class Admin extends Personne{
	String loging;
	String mdp;
	
	public Admin(String nom, String prenom, Date dateDeNaissance, String sexe, String email, String loging,
			String mdp) {
		super(nom, prenom, dateDeNaissance, sexe, email);
		this.loging = loging;
		this.mdp = mdp;
	}
}
