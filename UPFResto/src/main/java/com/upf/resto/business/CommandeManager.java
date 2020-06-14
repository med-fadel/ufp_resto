package com.upf.resto.business;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.upf.resto.dao.CommandeRepository;
import com.upf.resto.datamodel.Commande;
import com.upf.resto.datamodel.Etudiant;
import com.upf.resto.datamodel.Formation;
import com.upf.resto.datamodel.Repas;

@Component
public class CommandeManager{

	private @Autowired CommandeRepository repository;
	private @Autowired EtudiantManager etudiantManager;
	private @Autowired RepasManager repasManager;


	public void ajouterCommande(Commande commande) {
		Etudiant etudiant = commande.getEtudiant();
		List<Repas> repas = commande.getRepas();
		if(etudiant.getFormation() == Formation.INITIAL) {
			Double res = 0.0;
			res += repas.get(0)!=null?(repas.get(0).getPrix()*1.5): 0;
			res += repas.get(1)!=null?(repas.get(1).getPrix()*2): 0;
			res += repas.get(2)!=null?(repas.get(2).getPrix()*3): 0;
			commande.setPrixTotal(res);
		}
		else if(etudiant.getFormation() == Formation.CONTINUE) {
			Double total = repas.stream().map(Repas::getPrix).reduce(0.0, (subtotal, element) -> subtotal + element);
			commande.setPrixTotal(total);
		}
		repas.forEach(r-> repasManager.commanderRepas(r.getId()));
		etudiantManager.rechargeCompte(etudiant.getLoging(), (etudiant.getSolde() - commande.getPrixTotal()));
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
