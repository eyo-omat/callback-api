package com.clearinghub.callbackapi.configs;

import com.clearinghub.callbackapi.domians.twilio.TwilioClient;
import com.twilio.http.TwilioRestClient;
import com.twilio.type.PhoneNumber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by eyo
 * Project callback-api
 * User: eyo
 * Date: 09/04/2020
 * Time: 9:12 PM
 */
@Configuration
public class BeanConfig {

    /**
     * Create twilio rest client twilio client.
     *
     * @param configs the configs
     * @return the twilio client
     */
    @Bean
    public TwilioClient createTwilioRestClient(Configs configs) {
        TwilioRestClient twilioRestClient = new TwilioRestClient.Builder(configs.getAccountSID(),
                configs.getAuthToken()).build();

        PhoneNumber fromPhoneNumber = new PhoneNumber(Constants.WHATSAPP_PREFIX + configs.getTwilioNumber());
        PhoneNumber whatsappNumber = new PhoneNumber(Constants.WHATSAPP_PREFIX + configs.getTwilioNumber());

        return new TwilioClient(
                twilioRestClient,
                fromPhoneNumber,
                whatsappNumber
        );
    }
}
