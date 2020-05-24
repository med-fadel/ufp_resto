package com.upf.resto.dao;

import org.springframework.data.repository.CrudRepository;

import com.upf.resto.datamodel.Commande;

public interface CommandeRepository extends CrudRepository<Commande, String> {

}
