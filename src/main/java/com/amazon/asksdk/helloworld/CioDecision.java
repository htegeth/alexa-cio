package com.amazon.asksdk.helloworld;

import com.amazon.asksdk.helloworld.model.CioAntwort;

public interface CioDecision {

	CioAntwort gibAntwort();

	CioAntwort gibNachfrage();

	CioAntwort gibAntwort(String problemItem);

	CioAntwort sagHallo();
	
	CioAntwort sagTschuess();
}
