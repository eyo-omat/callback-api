package com.clearinghub.callbackapi.utils;

import com.clearinghub.callbackapi.configs.Configs;
import com.clearinghub.callbackapi.domians.twilio.TwilioClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by eyo
 * Project callback-api
 * User: eyo
 * Date: 09/04/2020
 * Time: 8:48 PM
 */
@Component
@RequiredArgsConstructor
public class TwilioMessageSenderClient {

    private static Logger logger = LoggerFactory.getLogger(TwilioMessageSenderClient.class);

    @NonNull
    private TwilioClient twilioClient;

    @NonNull
    private Configs config;

    @NonNull
    private Utilities utilities;

    /**
     * Send whats app message.
     *
     * @param destination the destination
     * @param body        the body
     * @return the message
     */
    public Message sendWhatsApp(final String destination, final String body) throws JsonProcessingException {
        final String METHOD = "sendWhatsapp ";
        Message whatsAppMessage = null;

        PhoneNumber destinationPhoneNumber = new PhoneNumber(destination);
        whatsAppMessage = sendMessage(destinationPhoneNumber, twilioClient.getWhatsAppNumber(), buildWhatsAppMessage(body));

        logger.info(String.format("%s%s", METHOD, whatsAppMessage.toString()));
        return whatsAppMessage;
    }

    private Message sendMessage(final PhoneNumber destination, final PhoneNumber sender, final String body) {
        return new MessageCreator(destination, sender, body).create(twilioClient.getTwilioRestClient());
    }

    private String buildWhatsAppMessage(String body) throws JsonProcessingException {
        if (body.trim().toLowerCase().isEmpty() || config.getGreetinglist().containsValue(body.trim().toLowerCase())) {
            return "Hello new user";
        }
        return utilities.invokeWiki(body);
    }
}
