package com.upf.resto.datamodel;

public class Commande {
	String id;
	Etudiant etudiant;
	Repas repas;
	Double prixTotal;
	
	public Commande(String id, Etudiant etudiant, Repas repas, Double prixTotal) {
		this.id = id;
		this.etudiant = etudiant;
		this.repas = repas;
		this.prixTotal = prixTotal;
	}

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
	
	
}
