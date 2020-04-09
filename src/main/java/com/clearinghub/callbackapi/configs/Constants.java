package com.clearinghub.callbackapi.configs;

/**
 * Created by eyo
 * Project callback-api
 * User: eyo
 * Date: 09/04/2020
 * Time: 8:18 PM
 */
public class Constants {

    public static final String BASE_API_PATH            = "/api/v1";
    public static final String WHATSAPP_API_ENDPOINT    = "/whatsapp_incoming_message";

    public static final String WHATSAPP_PREFIX              = "whatsapp:";
    public static final String TWIML_BODY_QUERY_PARAM_KEY   = "?body=";

    public static final String WHATSAPP_MESSAGE_PREFIX          = "Your Message Code is ";
    public static final String INVALID_URI_EXCEPTION_MESSAGE    = "Error While trying to build URI";
    public static final String RESPONSE_PREFIX_MESSAGE          = " Response: ";
    public static final String GENERAL_ERROR_MESSAGE            = "Oops something went wrong, please try again later";
}
