package com.clearinghub.callbackapi.services;

import com.clearinghub.callbackapi.configs.Configs;
import com.clearinghub.callbackapi.configs.Constants;
import com.clearinghub.callbackapi.dtos.responses.ResponseArray;
import com.clearinghub.callbackapi.utils.TwilioMessageSenderClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by eyo
 * Project callback-api
 * User: eyo
 * Date: 07/04/2020
 * Time: 11:47 PM
 */
@Service
@RequiredArgsConstructor
public class CallbackServiceImpl implements MessageSenderService{

    @NonNull
    private final Configs config;

    @NonNull
    private TwilioMessageSenderClient twilioMessageSenderClient;

    /**
     * Receive twilio callback.
     *
     * @param twilioCallbackBody the twilio callback body
     * @throws JsonProcessingException the json processing exception
     */
    public void receiveTwilioCallback(Map<String, String> twilioCallbackBody) throws JsonProcessingException {
        System.out.print(new ObjectMapper().writeValueAsString(twilioCallbackBody));
        Twilio.init(config.getAccountSID(), config.getAuthToken());
        String body = twilioCallbackBody.get("Body");
        String toNumber = twilioCallbackBody.get("From").replace("whatsapp:", "");
        System.out.println("This is Body: " + body + "-- This is from number: " + toNumber);
        System.out.println("This is the greeting map: " + config.getGreetinglist().toString());
        if (body.trim().toLowerCase().isEmpty() && config.getGreetinglist().containsValue(body.trim().toLowerCase())) {
            try {
                Message message = Message.creator(new PhoneNumber(toNumber), new PhoneNumber(config.getTwilioNumber()), "Okay this has to work").create();
                System.out.println("here is my id:"+message.getSid());
            } catch (Exception ex){
                System.out.println("Exception occured: " + ex);
            }
        }
        //return new ResponseArray();
    }

    @Override
    public ResponseArray sendSMS(String to, String body) {
        return null;
    }

    @Override
    public ResponseArray sendWhatsApp(String to, String body) {
        ResponseArray responseArray = null;
        try {
            twilioMessageSenderClient.sendWhatsApp(to, body);
            responseArray = buildSuccessResponse();
        } catch (Exception e){
            responseArray = buildResponseFromException(e);
        }
        return responseArray;
    }

    @Override
    public ResponseArray makeVoiceCall(String to, String body) {
        return null;
    }

    private ResponseArray buildSuccessResponse(){
        return new ResponseArray(true, null, HttpStatus.CREATED.value());
    }

    private ResponseArray buildResponseFromException(Exception ex) {
        ResponseArray responseArray = null;
        if (ex != null) {
            if (ex instanceof ApiException){
                ApiException apiException = (ApiException) ex;

                if (apiException != null && apiException.getStatusCode() != null) {
                    responseArray = new ResponseArray(
                            false,
                            apiException.getMessage(),
                            apiException.getStatusCode()
                    );
                }
            }
        }

        return responseArray == null ? buildGeneralErrorResponse() : responseArray;
    }

    private ResponseArray buildGeneralErrorResponse() {
        return new ResponseArray(false, Constants.GENERAL_ERROR_MESSAGE, HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
