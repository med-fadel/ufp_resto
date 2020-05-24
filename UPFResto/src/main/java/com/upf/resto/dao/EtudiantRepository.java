package com.upf.resto.dao;

import org.springframework.data.repository.CrudRepository;

import com.upf.resto.datamodel.Etudiant;

public interface EtudiantRepository extends CrudRepository<Etudiant, String> {
	
}
