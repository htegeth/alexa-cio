package com.amazon.asksdk.helloworld.model;

import java.util.Arrays;

public class StopCluster extends AntwortclusterAbstr{
	
	@Override
	protected void init() {
		antworten.put(Themen.STANDARD, Arrays.asList(//
				"Tsch� mit �",//
				"Tschau, bis zum n�chsten Jour Fix",//
				"Machs gut, und gr�� deine Frau!",//
				"Ich muss jetzt leider zum n�chsten Termin, tsch�ss"//
				));
		
	}
	
}
