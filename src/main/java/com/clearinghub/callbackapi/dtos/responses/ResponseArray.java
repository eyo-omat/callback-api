package com.clearinghub.callbackapi.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Response array.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseArray {

    private boolean success;
    private String  message;
    private int status;
}