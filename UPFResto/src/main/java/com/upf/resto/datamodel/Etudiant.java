package com.upf.resto.datamodel;

import java.time.Instant;
import java.util.Date;

public class Etudiant extends Personne{
	String loging;
	String mdp;
	Formation formation;
	double solde;
	Instant validite;
	public Etudiant(String nom, String prenom, Date dateDeNaissance, String sexe, String email, String loging,
			String mdp, Formation formation, double solde, Instant validite) {
		super(nom, prenom, dateDeNaissance, sexe, email);
		this.loging = loging;
		this.mdp = mdp;
		this.formation = formation;
		this.solde = solde;
		this.validite = validite;
	}
	
	public String getLoging() {
		return loging;
	}
	public String getMdp() {
		return mdp;
	}
	public Formation getFormation() {
		return formation;
	}
	public double getSolde() {
		return solde;
	}
	public Instant getValidite() {
		return validite;
	}
	public void setLoging(String loging) {
		this.loging = loging;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public void setValidite(Instant validite) {
		this.validite = validite;
	}
	
	
	
	
}
