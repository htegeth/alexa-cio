/**
    Copyright 2014-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.

    Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with the License. A copy of the License is located at

        http://aws.amazon.com/apache2.0/

    or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */
package com.amazon.asksdk.helloworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;
import com.amazon.speech.speechlet.SpeechletV2;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.asksdk.helloworld.model.CioAntwort;
import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;
import com.amazon.speech.ui.OutputSpeech;

/**
 * This sample shows how to create a simple speechlet for handling speechlet
 * requests.
 */
public class CioSpeechlet implements SpeechletV2 {
	private static final String CARD_NAME = "CIO";
	private static final String HELP_TEXT = "Du kannst sagen: Alexa, frage den CIO was mit dem Problem passieren soll!";
	private static final Logger log = LoggerFactory.getLogger(CioSpeechlet.class);

	private CioDecision cio = new CioDecisionImpl();

	@Override
	public void onSessionStarted(SpeechletRequestEnvelope<SessionStartedRequest> requestEnvelope) {
		log.info("onSessionStarted requestId={}, sessionId={}", requestEnvelope.getRequest().getRequestId(),
				requestEnvelope.getSession().getSessionId());
		// weitere Initaliserung hier
	}

	@Override
	public SpeechletResponse onLaunch(SpeechletRequestEnvelope<LaunchRequest> requestEnvelope) {
		log.info("onLaunch requestId={}, sessionId={}", requestEnvelope.getRequest().getRequestId(),
				requestEnvelope.getSession().getSessionId());
		String speechText = cio.sagHallo().getPlainText();
		return getAskResponse(CARD_NAME, speechText);
	}

	@Override
	public SpeechletResponse onIntent(SpeechletRequestEnvelope<IntentRequest> requestEnvelope) {
		IntentRequest request = requestEnvelope.getRequest();
		log.info("onIntent requestId={}, sessionId={}", request.getRequestId(),
				requestEnvelope.getSession().getSessionId());

		Intent intent = request.getIntent();
		String intentName = (intent != null) ? intent.getName() : null;

		if (intent.getSlot("problem") != null) {
			String slotvalue = intent.getSlot("problem").getValue();
			log.info("Slotvalue ist: {}", slotvalue);
		}

		if ("CIOIntent".equals(intentName)) {
			return gibAntwort();
		} else if ("AMAZON.HelpIntent".equals(intentName)) {
			return getAskResponse(CARD_NAME, HELP_TEXT);
		} else if ("AMAZON.StopIntent".equals(intentName)) {
			return SpeechletResponse.newTellResponse(getPlainTextOutputSpeech(cio.sagTschuess().getPlainText()));
		} else {
			return getAskResponse(CARD_NAME, cio.gibNachfrage().getPlainText());
		}
	}

	@Override
	public void onSessionEnded(SpeechletRequestEnvelope<SessionEndedRequest> requestEnvelope) {
		log.info("onSessionEnded requestId={}, sessionId={}", requestEnvelope.getRequest().getRequestId(),
				requestEnvelope.getSession().getSessionId());
	}

	private SpeechletResponse gibAntwort() {
		// Besorge eine Antwort
		CioAntwort antwort = cio.gibAntwort();
		return getAskResponse("CIO Antwort", antwort.getPlainText());
	}

	/**
	 * Helper method that creates a card object.
	 * 
	 * @param title
	 *            title of the card
	 * @param content
	 *            body of the card
	 * @return SimpleCard the display card to be sent along with the voice response.
	 */
	private SimpleCard getSimpleCard(String title, String content) {
		SimpleCard card = new SimpleCard();
		card.setTitle(title);
		card.setContent(content);

		return card;
	}

	/**
	 * Helper method for retrieving an OutputSpeech object when given a string of
	 * TTS.
	 * 
	 * @param speechText
	 *            the text that should be spoken out to the user.
	 * @return an instance of SpeechOutput.
	 */
	private PlainTextOutputSpeech getPlainTextOutputSpeech(String speechText) {
		PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
		speech.setText(speechText);
		return speech;
	}

	/**
	 * Helper method that returns a reprompt object. This is used in Ask responses
	 * where you want the user to be able to respond to your speech.
	 * 
	 * @param outputSpeech
	 *            The OutputSpeech object that will be said once and repeated if
	 *            necessary.
	 * @return Reprompt instance.
	 */
	private Reprompt getReprompt(OutputSpeech outputSpeech) {
		Reprompt reprompt = new Reprompt();
		reprompt.setOutputSpeech(outputSpeech);
		return reprompt;
	}

	/**
	 * Helper method for retrieving an Ask response with a simple card and reprompt
	 * included.
	 * 
	 * @param cardTitle
	 *            Title of the card that you want displayed.
	 * @param speechText
	 *            speech text that will be spoken to the user.
	 * @return the resulting card and speech text.
	 */
	private SpeechletResponse getAskResponse(String cardTitle, String speechText) {
		SimpleCard card = getSimpleCard(cardTitle, speechText);
		PlainTextOutputSpeech speech = getPlainTextOutputSpeech(speechText);
		Reprompt reprompt = getReprompt(speech);
		return SpeechletResponse.newAskResponse(speech, reprompt, card);
	}

}
