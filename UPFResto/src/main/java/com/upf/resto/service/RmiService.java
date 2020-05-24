package com.upf.resto.service;

import java.rmi.Remote;
import java.util.List;

import com.upf.resto.datamodel.Commande;
import com.upf.resto.datamodel.Repas;

public interface RmiService extends Remote{
	List<Repas> listeRepas();
	void effectuerCommande(Commande commande);
	List<Commande> consulterHistorique(String logging);
	Double consulaterSolde(String logging);
}
