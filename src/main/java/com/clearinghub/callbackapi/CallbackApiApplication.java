package com.clearinghub.callbackapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The type Callback api application.
 */
@EnableSwagger2
@SpringBootApplication
public class CallbackApiApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(CallbackApiApplication.class, args);
    }

}
