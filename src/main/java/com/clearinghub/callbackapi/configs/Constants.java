package com.clearinghub.callbackapi.configs;

/**
 * Created by eyo
 * Project callback-api
 * User: eyo
 * Date: 09/04/2020
 * Time: 8:18 PM
 */
public class Constants {

    /**
     * The constant BASE_API_PATH.
     */
    public static final String BASE_API_PATH            = "/api/v1";
    /**
     * The constant WHATSAPP_API_ENDPOINT.
     */
    public static final String WHATSAPP_API_ENDPOINT    = "/whatsapp_incoming_message";

    /**
     * The constant WHATSAPP_PREFIX.
     */
    public static final String WHATSAPP_PREFIX              = "whatsapp:";
    /**
     * The constant TWIML_BODY_QUERY_PARAM_KEY.
     */
    public static final String TWIML_BODY_QUERY_PARAM_KEY   = "?body=";

    /**
     * The constant WHATSAPP_MESSAGE_PREFIX.
     */
    public static final String WHATSAPP_MESSAGE_PREFIX          = "Your Message Code is ";
    /**
     * The constant INVALID_URI_EXCEPTION_MESSAGE.
     */
    public static final String INVALID_URI_EXCEPTION_MESSAGE    = "Error While trying to build URI";
    /**
     * The constant RESPONSE_PREFIX_MESSAGE.
     */
    public static final String RESPONSE_PREFIX_MESSAGE          = " Response: ";
    /**
     * The constant GENERAL_ERROR_MESSAGE.
     */
    public static final String GENERAL_ERROR_MESSAGE            = "Oops something went wrong, please try again later";
}
