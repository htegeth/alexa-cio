package com.amazon.asksdk.helloworld.model;

public enum Themen {
	BESTAENDIGKEIT("Best�ndigkeit",1),//
	DETAILS("Vergraben in Details",2),//
	KAPAZITAETEN("Kapazit�ten",3),//
	DELEGIEREN("Weg-Delegieren",4),//
	STANDARD("Standard",5)	;
	
	private String name;
	private int id;
	
	
	private Themen(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}
	
}
