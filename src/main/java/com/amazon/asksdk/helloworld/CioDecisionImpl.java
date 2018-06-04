package com.amazon.asksdk.helloworld;

import com.amazon.asksdk.helloworld.model.Antwortcluster;
import com.amazon.asksdk.helloworld.model.BedenkCluster;
import com.amazon.asksdk.helloworld.model.CioAntwort;
import com.amazon.asksdk.helloworld.model.HaehCluster;
import com.amazon.asksdk.helloworld.model.HalloCluster;
import com.amazon.asksdk.helloworld.model.StopCluster;

public class CioDecisionImpl implements CioDecision {
	
	private Antwortcluster cluster = new Antwortcluster();
	private HaehCluster hcluster = new HaehCluster();
	private HalloCluster halloCluster= new HalloCluster();
	private BedenkCluster bedenkCluster= new BedenkCluster();
	private StopCluster stopCluster = new StopCluster();
	
	@Override
	public CioAntwort gibAntwort() {
		return gibAntwort("");
	}

	@Override
	public CioAntwort gibAntwort(String problemItem) {
		String answerpost = cluster.gibAntwort();
		String answerpre= bedenkCluster.gibAntwort();
		return new CioAntwort(answerpre+", "+answerpost);
	}

	@Override
	public CioAntwort gibNachfrage() {
		String question = hcluster.gibAntwort();
		return new CioAntwort(question);
	}
	
	public CioAntwort sagHallo() {
		String hallo= halloCluster.gibAntwort();
		return new CioAntwort(hallo);
	}

	@Override
	public CioAntwort sagTschuess() {
		String bye= stopCluster.gibAntwort();
		return new CioAntwort(bye);
	}

}
