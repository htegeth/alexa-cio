package com.amazon.asksdk.helloworld.model;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

@Test
class AntwortclusterTest {
	Antwortcluster cluster= new Antwortcluster();

	@Test(invocationCount=100,threadPoolSize=10)
	void testGibAntwort() {
		
		String answer=cluster.gibAntwort();
		System.out.println(answer);
		assertTrue(answer.length()!=0);
	}

}
