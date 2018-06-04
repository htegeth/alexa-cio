package com.amazon.asksdk.helloworld.model;

import java.util.Arrays;

public class HalloCluster extends AntwortclusterAbstr{
	
	@Override
	protected void init() {
		antworten.put(Themen.STANDARD, Arrays.asList(//
				"Na, alles senkrecht?",//
				"Geht es etwa um XML?",//
				"Hey, ich kenn mich mit Block-Chains aus! Geht es darum?",//
				"Ich hab nicht viel Zeit, ich muss gleich zu einem wichtigen Meeting",//
				"i-Health, darum geht es, stimmts?"//
				));
		
	}
	
}
