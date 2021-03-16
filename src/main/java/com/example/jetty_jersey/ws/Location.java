package com.example.jetty_jersey.ws;

public class Location {

	String pays;
	String ville;
	String rue;
	int numéro;
	int codePostal;
	// Et un attribut coordonnées géographiques

	public Location(String pays, String ville, String rue, int numéro, int codePostal) {
		this.pays = pays;
		this.ville = ville;
		this.rue = rue;
		this.numéro = numéro;
		this.codePostal = codePostal;

	}

	public Location() {

	}

}
