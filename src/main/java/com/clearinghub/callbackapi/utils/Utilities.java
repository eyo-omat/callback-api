package com.clearinghub.callbackapi.utils;

import com.clearinghub.callbackapi.configs.Configs;
import com.clearinghub.callbackapi.configs.ObjectMapperConfiguration;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by eyo
 * Project callback-api
 * User: eyo
 * Date: 10/04/2020
 * Time: 2:32 PM
 */
@Component
@RequiredArgsConstructor
public class Utilities {
    @NonNull
    private final RestTemplate restTemplate;

    @NonNull
    private final Configs configs;

    public String invokeWiki(String text) throws JsonProcessingException {
        String response = restTemplate.getForObject(configs.getWikiApi(), String.class, text);
        Map<String, Object> wikiMap = new ObjectMapperConfiguration().objectMapper().readValue(response, Map.class);
        List<?> relatedTopics = (ArrayList) wikiMap.get("RelatedTopics");
        Map<String, String> relatedTopicsMap = (Map) relatedTopics.get(0);

        if (wikiMap.get("Abstract").toString().isEmpty()){
            return "*" + wikiMap.get("Heading").toString() + "* \n\n" + relatedTopicsMap.get("Text");
        }
        return "*" + wikiMap.get("Heading").toString() + "* \n\n" + wikiMap.get("Abstract");
    }
}
