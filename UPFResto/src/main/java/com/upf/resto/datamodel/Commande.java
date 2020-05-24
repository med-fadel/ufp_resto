package com.upf.resto.datamodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String id;
	private Etudiant etudiant;
	private Repas repas;
	private Double prixTotal;
	private Boolean valide = false;
	
	public String getId() {
		return id;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public Repas getRepas() {
		return repas;
	}

	public Double getPrixTotal() {
		return prixTotal;
	}
	
	public Boolean getValide() {
		return valide;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public void setRepas(Repas repas) {
		this.repas = repas;
	}

	public void setPrixTotal(Double prixTotal) {
		this.prixTotal = prixTotal;
	}

	public void setValide(Boolean valide) {
		this.valide = valide;
	}
}
