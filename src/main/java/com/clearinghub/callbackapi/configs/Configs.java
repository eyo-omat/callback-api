package com.clearinghub.callbackapi.configs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * The type Configs.
 */
@Component
@Configuration
@ConfigurationProperties("callback.api")
@Data
@NoArgsConstructor
public class Configs {

    private String applicationName;
    private String springApplicationName;

    @JsonProperty("${callback.api.greetinglist}")
    private HashMap<String, String> greetinglist;

    @JsonProperty("${callback.api.twilioNumber}")
    private String twilioNumber;

    @JsonProperty("${callback.api.twilioAccountSID}")
    private String accountSID;

    @JsonProperty("${callback.api.twilioAuthToken}")
    private String authToken;

}
