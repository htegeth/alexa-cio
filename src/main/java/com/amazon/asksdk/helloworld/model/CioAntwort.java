package com.amazon.asksdk.helloworld.model;

public class CioAntwort {
	
	private String plainText;
	
	public CioAntwort() {
	}

	public CioAntwort(String plainText) {
		super();
		this.plainText = plainText;
	}
	
	public void setPlainText(String plainText) {
		this.plainText = plainText;
	}
	
	public String getPlainText() {
		return plainText;
	}
	

}
