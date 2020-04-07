package com.clearinghub.callbackapi.controllers;

import com.clearinghub.callbackapi.dtos.responses.ResponseArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

public class CallbackController {

    @PostMapping("/incoming_message")
    public ResponseEntity<ResponseArray> acceptMessage(@RequestBody Map<String, String> body){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
