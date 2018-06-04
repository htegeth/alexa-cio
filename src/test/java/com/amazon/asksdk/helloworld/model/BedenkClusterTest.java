package com.amazon.asksdk.helloworld.model;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class BedenkClusterTest {

	@Test(invocationCount = 5)
	public void gibAntwort() {
		BedenkCluster cluster = new BedenkCluster();
		String antwort = cluster.gibAntwort();
		System.out.println(antwort);
		Assert.assertTrue(antwort != null && antwort.length() > 0);
	}
}