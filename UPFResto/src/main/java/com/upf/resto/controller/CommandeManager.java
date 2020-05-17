package com.upf.resto.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.upf.resto.datamodel.Commande;

public class CommandeManager {
	private Map<String,Commande> commandes = new HashMap<>();
	
	public void ajouterCommande(Commande commande) {
		commandes.put(commande.getId(), commande);
	}
	
	public void supprimerCommande(String id) {
		commandes.remove(id);
	}
	
	public List<Commande> consulterCommande(String logingEtud){
		return commandes.values().stream().filter(e-> e.getEtudiant().getLoging().equals(logingEtud)).collect(Collectors.toList());
	}
	
	
}
