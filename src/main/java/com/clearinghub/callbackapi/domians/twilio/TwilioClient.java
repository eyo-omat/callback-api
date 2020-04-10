package com.clearinghub.callbackapi.domians.twilio;

import com.twilio.http.TwilioRestClient;
import com.twilio.type.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by eyo
 * Project callback-api
 * User: eyo
 * Date: 09/04/2020
 * Time: 9:08 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TwilioClient {
    private TwilioRestClient twilioRestClient;
    private PhoneNumber fromNumber;
    private PhoneNumber whatsAppNumber;
}
