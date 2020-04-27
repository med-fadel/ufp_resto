package com.upf.resto.datamodel;

import static com.upf.resto.datamodel.Formation.INITIAL;

import java.time.Instant;

public class IniEtudiant extends Etudiant{
	
	public IniEtudiant(String email, String pwd, Double solde, Instant validite) {
		super(email, pwd, INITIAL, solde, validite);
	}
	
	public IniEtudiant(String email, String pwd, Instant validite) {
		super(email, pwd, INITIAL, 0D, validite);
	}

}
