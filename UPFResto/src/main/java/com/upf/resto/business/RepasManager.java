package com.upf.resto.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.upf.resto.dao.RepasRepository;
import com.upf.resto.datamodel.Repas;

@Component
public class RepasManager {
	private @Autowired RepasRepository repository;
	
	public void ajouterRepas(Repas repas) {
		repository.save(repas);
	}
	
	public void supprimerRepas(String id) {
		repository.delete(id);
	}
	
	public void commanderRepas(String id) {
		Repas repas = repository.findOne(id);
		repas.setQuantite(repas.getQuantite()-1);
		repository.save(repas);
	}
	
	public List<Repas> getListRepas(){
		List<Repas> res = new ArrayList<>();
		repository.findAll().forEach(res::add);
		return res;
	}
	
	public Repas getRepas(String id) {
		return repository.findOne(id);
	}
}
