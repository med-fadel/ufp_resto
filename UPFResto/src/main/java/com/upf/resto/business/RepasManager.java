package com.upf.resto.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.upf.resto.dao.RepasRepository;
import com.upf.resto.datamodel.Repas;

public class RepasManager {
	private @Autowired RepasRepository repository;
	
	public void ajouterRepas(Repas repas) {
		repository.save(repas);
	}
	
	public void supprimerRepas(String id) {
		repository.delete(id);
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
