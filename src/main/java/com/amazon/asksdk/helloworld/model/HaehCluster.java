package com.amazon.asksdk.helloworld.model;

import java.util.Arrays;

public class HaehCluster extends AntwortclusterAbstr{
	
	@Override
	protected void init() {
		antworten.put(Themen.STANDARD, Arrays.asList(//
				"Hallo! Oh wir haben uns aber schon lange nicht mehr gesehen. Arbeiten sie hier noch?",//
				"Hi! na alles senkrecht?",//
				"Oh hallo, na gut für ein kurzes Gespräch im Türrahmen habe ich noch Zeit. Dann mal los",//
				"Warum geht es denn? Ist Thorsten nicht da?"//
				));
		
	}
	
}
