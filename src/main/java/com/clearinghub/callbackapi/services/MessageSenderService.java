package com.clearinghub.callbackapi.services;

import com.clearinghub.callbackapi.dtos.responses.ResponseArray;

/**
 * Created by eyo
 * Project callback-api
 * User: eyo
 * Date: 09/04/2020
 * Time: 8:53 PM
 */
public interface MessageSenderService {

    ResponseArray sendSMS(final String to, final String body);
    ResponseArray sendWhatsApp(final String to, final String body);
    ResponseArray makeVoiceCall(final String to, final String body);
}
