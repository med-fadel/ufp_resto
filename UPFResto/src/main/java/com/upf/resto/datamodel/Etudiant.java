package com.upf.resto.datamodel;

import java.time.Instant;

public class Etudiant {
	String email;
	String pwd;
	Formation formation;
	Double solde;
	Instant validite;
	
	public Etudiant(String email, String pwd, Formation formation, Double solde, Instant validite) {
		this.email = email;
		this.pwd = pwd;
		this.formation = formation;
		this.solde = solde;
		this.validite = validite;
	}
}
