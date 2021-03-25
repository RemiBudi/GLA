package com.Places.dao;

public class Location {

	String pays;
	String ville;
	String rue;
	int numero;
	int codePostal;
	// Et un attribut coordonnées géographiques

	public Location(String pays, String ville, String rue, int numero, int codePostal) {
		this.pays = pays;
		this.ville = ville;
		this.rue = rue;
		this.numero = numero;
		this.codePostal = codePostal;

	}

	public Location() {

	}

}
