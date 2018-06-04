package com.amazon.asksdk.helloworld.model;

import java.util.Arrays;

public class BedenkCluster extends AntwortclusterAbstr{
	
	@Override
	protected void init() {
		antworten.put(Themen.STANDARD, Arrays.asList(//
				"Hmm",//
				"Ja ja",//
				"Ach so. ja",//
				"OK",//
				"ja"//
				));
		
	}
	
}
