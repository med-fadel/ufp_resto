package com.upf.resto.datamodel;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Etudiant extends Personne{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String loging;
	private String mdp;
	private Formation formation;
	private Double solde;
	private Instant validite;
	
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
