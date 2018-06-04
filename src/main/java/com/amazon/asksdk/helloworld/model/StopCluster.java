package com.amazon.asksdk.helloworld.model;

import java.util.Arrays;

public class StopCluster extends AntwortclusterAbstr{
	
	@Override
	protected void init() {
		antworten.put(Themen.STANDARD, Arrays.asList(//
				"Tschö mit Ö",//
				"Tschau, bis zum nächsten Jour Fix",//
				"Machs gut, und grüß deine Frau!",//
				"Ich muss jetzt leider zum nächsten Termin, tschüss"//
				));
		
	}
	
}
