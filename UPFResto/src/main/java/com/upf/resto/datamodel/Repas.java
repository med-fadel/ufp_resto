package com.upf.resto.datamodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Repas {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String id;
	private Double prix;
	private Double quantite;
	
	public Repas(String id, Double prix, Double quantite) {
		super();
		this.id = id;
		this.prix = prix;
		this.quantite = quantite;
	}

	public String getId() {
		return id;
	}
	
	public Double getPrix() {
		return prix;
	}
	
	public Double getQuantite() {
		return quantite;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	
	public void setQuantite(Double quantite) {
		this.quantite = quantite;
	}
}
