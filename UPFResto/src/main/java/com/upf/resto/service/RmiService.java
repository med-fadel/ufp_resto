package com.upf.resto.service;

import java.rmi.Remote;
import java.util.List;

import com.upf.resto.datamodel.Commande;
import com.upf.resto.datamodel.Etudiant;
import com.upf.resto.datamodel.Repas;

public interface RmiService extends Remote{
	public void ajouterEtudiant(Etudiant etudiant);
	public void supprimerEtudiant(String logingEtud);
	public void rechargeCompte(String logingEtud, Double solde);
	public List<Etudiant> listerEtudiants();
	public double consulterSolde(String logingEtud);
	public Etudiant auth(String login, String mdp);
	public void ajouterCommande(Commande commande);
	public void supprimerCommande(String id);
	public void validerCommande(String id);
	public List<Commande> listerCommandes();
	public List<Commande> consulterCommande(String logingEtud);
	public void ajouterRepas(Repas repas);
	public void supprimerRepas(String id);
	public List<Repas> getListRepas();
	public Repas getRepas(String id);
}
