package com.upf.resto.controller;

import java.util.HashMap;
import java.util.Map;

import com.upf.resto.datamodel.Etudiant;

public class UtilisateursManager {
	
	private Map<String, Etudiant> utilisateurs = new HashMap<>();
	
	public void ajouterUtilisateur(Etudiant etudiant) {
		utilisateurs.put(etudiant.getLoging(), etudiant);
	}
	
	public void supprimerUtilisateur(String logingEtud) {
		utilisateurs.remove(logingEtud);
	}
	
	public void rechargeCompte(String logingEtud, Double solde) {
		Etudiant etudiant = utilisateurs.get(logingEtud);
		etudiant.setSolde(solde);
	}
	
	double consulterSolde(String logingEtud){
		return utilisateurs.get(logingEtud).getSolde();
	}
}
