package com.upf.resto.business;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.upf.resto.dao.CommandeRepository;
import com.upf.resto.datamodel.Commande;

public class CommandeManager{
	
	private @Autowired CommandeRepository repository;
	
	
	public void ajouterCommande(Commande commande) {
		repository.save(commande);
	}
	
	public void supprimerCommande(String id) {
		repository.delete(id);
	}
	
	public void validerCommande(String id) {
		Commande commande = repository.findOne(id);
		commande.setValide(true);
		repository.save(commande);
	}
	
	public List<Commande> listerCommandes(){
		List<Commande> res = new ArrayList<>();
		repository.findAll().forEach(res::add);
		return res;
	}
	
	public List<Commande> consulterCommande(String logingEtud){
		return listerCommandes().stream().filter(e->e.getEtudiant().getLoging().equals(logingEtud)).collect(Collectors.toList());
	}
}
