package com.amazon.asksdk.helloworld.model;

import java.util.Arrays;

public class Antwortcluster extends AntwortclusterAbstr{
	
	
	@Override
	protected void init() {
		antworten.put(Themen.BESTAENDIGKEIT, Arrays.asList(//
				"Und wo ist das Problem? Es ist doch gut so wie es ist!",//
				"Also das lassen wir besser so!",//
				"Aber daf�r gibt es doch schon Vorgaben. Such mal im Confluence, da steht alles!",//
				"Das ist doch nur der Wunsch eines Einzelnen "//
				));
		
		antworten.put(Themen.DETAILS, Arrays.asList(//
				"Es ist besser du erstellst dazu erst einmal ein Konzept",//
				"Am besten wird es sein, du analysierst erstmal das Problem",//
				"Ich brauche mehr Details",//
				"Ich brauche noch mehr Details"//
				));
		
		antworten.put(Themen.KAPAZITAETEN, Arrays.asList(//
				"Daf�r haben wir nicht genug Resourcen",//
				"Hast du mit dem Team schon dar�ber geredet"
				));
		
		antworten.put(Themen.DELEGIEREN, Arrays.asList(//
				"Tanja erstellt dazu ein Konzept",//
				"Thorsten erstellt dazu ein Konzept",//
				"Nimm den Punkt auf wir sprechen beim n�chsten mal dar�ber",//
				"Tanja spricht mit den Teams"//
				));
		
		antworten.put(Themen.KAPAZITAETEN, Arrays.asList(//
				"ich mache einen Termin mit allen Betroffenen",//
				"sprich erst mit allen Betroffenen",//
				"Schreib es auf, ich besch�ftige mich sp�ter damit",//
				"erstelle eine Power Point f�r den Lenkungsausschuss"//
				));
		
		antworten.put(Themen.STANDARD, Arrays.asList(//
				"Wir besprechen das in der Kooperation",//
				"Daraus machen wir am besten ein Projekt",//
				"Da muss ich nochmal schauen"
				));
		
	}

	
}
