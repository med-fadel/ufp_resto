package com.upf.resto.business;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.upf.resto.dao.EtudiantRepository;
import com.upf.resto.datamodel.Commande;
import com.upf.resto.datamodel.Etudiant;
import com.upf.resto.datamodel.Formation;

@Component
public class EtudiantManager{
	private @Autowired EtudiantRepository repository;

	public void ajouterEtudiant(Etudiant etudiant) {
		if(etudiant.getFormation() == Formation.INITIAL) {
			// 3 ans
			etudiant.setValidite(Instant.now().plusMillis(94670778));
		}
		else if(etudiant.getFormation() == Formation.CONTINUE) {
			// 3 mois
			etudiant.setValidite(Instant.now().plusMillis(7889231));
		}
		repository.save(etudiant);
	}

	public void supprimerEtudiant(String logingEtud) {
		repository.delete(logingEtud);
	}

	public void rechargeCompte(String logingEtud, Double solde) {
		Etudiant etudiant = repository.findOne(logingEtud);
		etudiant.setSolde(solde);
		repository.save(etudiant);
	}

	public List<Etudiant> listerEtudiants(){
		List<Etudiant> res = new ArrayList<>();
		repository.findAll().forEach(res::add);
		return res;
	}

	public double consulterSolde(String logingEtud){
		return repository.findOne(logingEtud).getSolde();
	}

	public Etudiant auth(String login, String mdp) {
		Etudiant etudiant = repository.findOne(login);
		if (etudiant.getMdp().equals(mdp)) {
			return etudiant;
		}
		else {
			return null;
		}
	}
}
