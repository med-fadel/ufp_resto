package com.upf.resto.datamodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin extends Personne{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String loging;
	private String mdp;

	public String getLoging() {
		return loging;
	}

	public String getMdp() {
		return mdp;
	}

	public void setLoging(String loging) {
		this.loging = loging;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
}
