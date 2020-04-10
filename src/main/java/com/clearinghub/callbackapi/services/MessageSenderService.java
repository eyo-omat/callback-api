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

    /**
     * Send sms response array.
     *
     * @param to   the to
     * @param body the body
     * @return the response array
     */
    ResponseArray sendSMS(final String to, final String body);

    /**
     * Send whats app response array.
     *
     * @param to   the to
     * @param body the body
     * @return the response array
     */
    ResponseArray sendWhatsApp(final String to, final String body);

    /**
     * Make voice call response array.
     *
     * @param to   the to
     * @param body the body
     * @return the response array
     */
    ResponseArray makeVoiceCall(final String to, final String body);
}
