package com.clearinghub.callbackapi.configs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${callback.api.twilioNumber}")
    private String twilioNumber;

    @JsonProperty("${callback.api.twilioAccountSID}")
    private String accountSID;

    @JsonProperty("${callback.api.twilioAuthToken}")
    private String authToken;

    @Value("${callback.api.wikiApi}")
    private String wikiApi;

    @Value("${callback.api.restTemplateRequestTimeout}")
    private int restTemplateRequestTimeout;
    @Value("${callback.api.restTemplateSocketTimeout}")
    private int restTemplateSocketTimeout;
    @Value("${callback.api.restTemplateConnectTimeout}")
    private int restTemplateConnectTimeout;
    @Value("${callback.api.maxConnectionPoolSize}")
    private int maxConnectionPoolSize;
    @Value("${callback.api.defaultMaxPerRouteConnectionPoolSize}")
    private int defaultMaxPerRouteConnectionPoolSize;

}
