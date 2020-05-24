package com.upf.resto.business;

import org.springframework.beans.factory.annotation.Autowired;

import com.upf.resto.dao.EtudiantRepository;
import com.upf.resto.datamodel.Etudiant;

public class EtudiantManager{
	private @Autowired EtudiantRepository repository;
	
	public void ajouterEtudiant(Etudiant etudiant) {
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
	
	public double consulterSolde(String logingEtud){
		return repository.findOne(logingEtud).getSolde();
	}
}
