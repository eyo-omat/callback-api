package com.clearinghub.callbackapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class CallbackApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CallbackApiApplication.class, args);
    }

}
