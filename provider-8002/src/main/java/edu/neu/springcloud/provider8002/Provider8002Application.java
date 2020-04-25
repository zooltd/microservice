package edu.neu.springcloud.provider8002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Provider8002Application {

    public static void main(String[] args) {
        SpringApplication.run(Provider8002Application.class, args);
    }

}
