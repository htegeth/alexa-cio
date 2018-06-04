package com.amazon.asksdk.helloworld;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import org.apache.commons.io.IOUtils;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import com.amazonaws.services.lambda.runtime.Context;

public class CioRequestStreamHandlerTest {

  @Test
  public void CioRequestStreamHandler() throws IOException {
	  
	  CioRequestStreamHandler handler= new CioRequestStreamHandler();
	  
	  InputStream input= this.getClass().getResourceAsStream("alexaRequest.json");
	  OutputStream output = new ByteArrayOutputStream();
	  
	  Context context = Mockito.mock(Context.class);
	  
	  handler.handleRequest(input, output, context);
	  
	  System.out.println( output.toString());
  }
}
