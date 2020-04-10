package com.clearinghub.callbackapi.configs;


import lombok.RequiredArgsConstructor;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


@Configuration
@RequiredArgsConstructor
public class RestTemplateConfig {
    /**
     * The Configs.
     */
    private final Configs configs;


    /**
     * Pooling http client connection manager pooling http client connection manager.
     *
     * @return the pooling http client connection manager
     */
    @Bean
    public PoolingHttpClientConnectionManager poolingHttpClientConnectionManager() {
        PoolingHttpClientConnectionManager result = new PoolingHttpClientConnectionManager();
        result.setMaxTotal(configs.getMaxConnectionPoolSize());
        result.setDefaultMaxPerRoute(configs.getDefaultMaxPerRouteConnectionPoolSize());
        return result;
    }

    /**
     * Request config request config.
     *
     * @return the request config
     */
    @Bean
    public RequestConfig requestConfig() {
        return RequestConfig
                .custom()
                .setConnectionRequestTimeout(configs.getRestTemplateRequestTimeout())
                .setConnectTimeout(configs.getRestTemplateSocketTimeout())
                .setSocketTimeout(configs.getRestTemplateConnectTimeout())
                .build();
    }

    /**
     * Http client closeable http client.
     *
     * @param poolingHttpClientConnectionManager the pooling http client connection manager
     * @param requestConfig                      the request config
     * @return the closeable http client
     */
    @Bean
    public CloseableHttpClient httpClient(
            PoolingHttpClientConnectionManager poolingHttpClientConnectionManager,
            RequestConfig requestConfig
    ) {
        return HttpClientBuilder
                .create()
                .setConnectionManager(poolingHttpClientConnectionManager)
                .setDefaultRequestConfig(requestConfig)
                .build();
    }

    /**
     * Rest template rest template.
     *
     * @param httpClient the http client
     * @return the rest template
     */
    @Bean
    public RestTemplate restTemplate(HttpClient httpClient) {
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);

        return new RestTemplate(requestFactory);
    }
}