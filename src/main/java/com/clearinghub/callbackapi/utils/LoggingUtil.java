package com.clearinghub.callbackapi.utils;

/**
 * Created by eyo
 * Project callback-api
 * User: eyo
 * Date: 09/04/2020
 * Time: 8:22 PM
 */
public class LoggingUtil {

    private static final String MESSAGE_SIGN_WRAPPER    = "######## ";
    private static final String ENTERING_PREFIX         = "Entering ";
    private static final String EXITING_PREFIX          = "Exiting ";
    private static final String METHOD_SUFFIX           = " method ";

    /**
     * Gets entering method message.
     *
     * @param method the method
     * @return the entering method message
     */
    public static String getEnteringMethodMessage (String method) {
        return wrappingMessage(ENTERING_PREFIX + method + METHOD_SUFFIX);
    }

    /**
     * Gets exiting method message.
     *
     * @param method the method
     * @return the exiting method message
     */
    public static String getExitingMethodMessage(String method) {
        return wrappingMessage(EXITING_PREFIX + method + METHOD_SUFFIX);
    }

    private static String wrappingMessage(String message) {
        return MESSAGE_SIGN_WRAPPER + message + MESSAGE_SIGN_WRAPPER;
    }
}
