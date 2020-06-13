package com.upf.resto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.upf.resto.business.CommandeManager;
import com.upf.resto.business.EtudiantManager;
import com.upf.resto.business.RepasManager;
import com.upf.resto.datamodel.Commande;
import com.upf.resto.datamodel.Etudiant;
import com.upf.resto.datamodel.Repas;

public class RmiServiceImpl implements RmiService {
	private @Autowired CommandeManager commandeManager;
	private @Autowired EtudiantManager etudiantManager;
	private @Autowired RepasManager repasManager;
	@Override
	public void ajouterEtudiant(Etudiant etudiant) {
		etudiantManager.ajouterEtudiant(etudiant);
	}
	@Override
	public void supprimerEtudiant(String logingEtud) {
		etudiantManager.supprimerEtudiant(logingEtud);
	}
	@Override
	public void rechargeCompte(String logingEtud, Double solde) {
		etudiantManager.rechargeCompte(logingEtud, solde);
	}
	@Override
	public List<Etudiant> listerEtudiants() {
		return etudiantManager.listerEtudiants();
	}
	@Override
	public double consulterSolde(String logingEtud) {
		return etudiantManager.consulterSolde(logingEtud);
	}
	@Override
	public Etudiant auth(String login, String mdp) {
		return etudiantManager.auth(login, mdp);
	}
	@Override
	public void ajouterCommande(Commande commande) {
		commandeManager.ajouterCommande(commande);
	}
	@Override
	public void supprimerCommande(String id) {
		commandeManager.supprimerCommande(id);
	}
	@Override
	public void validerCommande(String id) {
		commandeManager.validerCommande(id);
	}
	@Override
	public List<Commande> listerCommandes() {
		return commandeManager.listerCommandes();
	}
	@Override
	public List<Commande> consulterCommande(String logingEtud) {
		return commandeManager.consulterCommande(logingEtud);
	}
	@Override
	public void ajouterRepas(Repas repas) {
		repasManager.ajouterRepas(repas);
	}
	@Override
	public void supprimerRepas(String id) {
		repasManager.supprimerRepas(id);
	}
	@Override
	public List<Repas> getListRepas() {
		return repasManager.getListRepas();
	}
	@Override
	public Repas getRepas(String id) {
		return repasManager.getRepas(id);
	}

}
