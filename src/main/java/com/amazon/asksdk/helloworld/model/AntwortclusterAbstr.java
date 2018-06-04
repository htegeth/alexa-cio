package com.amazon.asksdk.helloworld.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.RandomUtils;

public abstract class AntwortclusterAbstr {

	protected Map<Themen, List<String>> antworten = new HashMap<>();

	public AntwortclusterAbstr() {
		super();
		init();
	}

	public String gibAntwort() {
		int randomThema = RandomUtils.nextInt(0, antworten.keySet().size());
		Themen currentThema = (Themen) antworten.keySet().toArray()[randomThema];
		int randomAnswersNumber;
		randomAnswersNumber = RandomUtils.nextInt(0, antworten.get(currentThema).size());

		String result = antworten.get(currentThema).get(randomAnswersNumber);
		return result;
	}

	protected abstract void init();
}
