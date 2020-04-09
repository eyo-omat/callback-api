package com.clearinghub.callbackapi.controllers;

import com.clearinghub.callbackapi.configs.Constants;
import com.clearinghub.callbackapi.dtos.responses.ResponseArray;
import com.clearinghub.callbackapi.services.CallbackServiceImpl;
import com.clearinghub.callbackapi.utils.LoggingUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by eyo
 * Project callback-api
 * User: eyo
 * Date: 07/04/2020
 * Time: 10:52 PM
 */
@RestController
@RequiredArgsConstructor
public class CallbackController {
    @NonNull
    private static Logger logger = LoggerFactory.getLogger(CallbackController.class);

    @NonNull
    private final CallbackServiceImpl callbackService;

    @PostMapping("/incoming")
    public ResponseEntity<ResponseArray> receiveMessageCallback(@RequestBody Map<String, String> messageBody) throws JsonProcessingException {
        callbackService.receiveTwilioCallback(messageBody);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(Constants.WHATSAPP_API_ENDPOINT)
    //public ResponseEntity<ResponseArray> receiveTwilioWhatsappMessage(@RequestParam Map<String, String> messageBody) throws JsonProcessingException {
    public ResponseEntity<ResponseArray> receiveTwilioWhatsappMessage(@RequestParam final String to, @RequestParam final String body) throws JsonProcessingException {
        final String METHOD = "send whatsapp ";
        logger.info(LoggingUtil.getEnteringMethodMessage(METHOD));
        ResponseArray responseArray = callbackService.sendWhatsApp(to, body);
        logger.info(METHOD + Constants.RESPONSE_PREFIX_MESSAGE + responseArray.toString());
        logger.info(LoggingUtil.getExitingMethodMessage(METHOD));
        return new ResponseEntity<>(responseArray, HttpStatus.valueOf(responseArray.getStatus()));
    }

    @PostMapping("/status_callback")
    public ResponseEntity<ResponseArray> receiveStatusCallback(@RequestBody Map<String, String> statusBody) {

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
