package com.clearinghub.callbackapi.configs;

/**
 * Created by eyo
 * Project callback-api
 * User: eyo
 * Date: 09/04/2020
 * Time: 8:18 PM
 */
public class Constants {

    String BASE_API_PATH            = "/api/v1";
    String SMS_API_ENDPOINT         = "/sms";
    String WHATSAPP_API_ENDPOINT    = "/whatsapp";
    String VOICE_API_ENDPOINT       = "/voice";

    String WHATSAPP_PREFIX              = "whatsapp:";
    String TWIML_BODY_QUERY_PARAM_KEY   = "?body=";

    String WHATSAPP_MESSAGE_PREFIX          = "Your Message Code is ";
    String INVALID_URI_EXCEPTION_MESSAGE    = "Error While trying to build URI";
    String RESPONSE_PREFIX_MESSAGE          = " Response: ";
    String GENERAL_ERROR_MESSAGE            = "Oops something went wrong, please try again later";
}
