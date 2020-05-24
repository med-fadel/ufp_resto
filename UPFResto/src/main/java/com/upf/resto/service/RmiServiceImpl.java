package com.upf.resto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.upf.resto.business.CommandeManager;
import com.upf.resto.business.EtudiantManager;
import com.upf.resto.business.RepasManager;
import com.upf.resto.datamodel.Commande;
import com.upf.resto.datamodel.Repas;

public class RmiServiceImpl implements RmiService {
	private @Autowired CommandeManager commandeManager;
	private @Autowired EtudiantManager etudiantManager;
	private @Autowired RepasManager repasManager;

	@Override
	public List<Repas> listeRepas() {
		return repasManager.getListRepas();
	}

	@Override
	public void effectuerCommande(Commande commande) {
		commandeManager.ajouterCommande(commande);

	}

	@Override
	public List<Commande> consulterHistorique(String logging) {
		return commandeManager.consulterCommande(logging);
	}

	@Override
	public Double consulaterSolde(String logging) {
		return etudiantManager.consulterSolde(logging);
	}

}
