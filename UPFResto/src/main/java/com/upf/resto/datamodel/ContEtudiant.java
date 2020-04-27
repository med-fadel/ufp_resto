package com.upf.resto.datamodel;

import static com.upf.resto.datamodel.Formation.INITIAL;

import java.time.Instant;

public class ContEtudiant extends Etudiant{
	
	public ContEtudiant(String email, String pwd, Double solde, Instant validite) {
		super(email, pwd, INITIAL, solde, validite);
	}
	
	public ContEtudiant(String email, String pwd, Double solde) {
		super(email, pwd, INITIAL, solde, Instant.now().plusSeconds(7890000));
	}
	
	public ContEtudiant(String email, String pwd, Instant validite) {
		super(email, pwd, INITIAL, 0D, validite);
	}
}
