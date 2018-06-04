package com.amazon.asksdk.helloworld;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

public class SmartHandler implements RequestStreamHandler{
	 private static final Logger log = LoggerFactory.getLogger(SmartHandler.class);

	@Override
	public void handleRequest(InputStream arg0, OutputStream arg1, Context arg2) throws IOException {
		log.info("Handler wird aufgerufen");
		StringWriter writer = new StringWriter();
		IOUtils.copy(arg0, writer);
		String theString = writer.toString();
		log.info("Das pustet der Inpoutstream raus: "+theString);
		
	}

}
