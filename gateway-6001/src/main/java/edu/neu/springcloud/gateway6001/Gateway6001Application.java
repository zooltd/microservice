package edu.neu.springcloud.gateway6001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class Gateway6001Application {

    public static void main(String[] args) {
        SpringApplication.run(Gateway6001Application.class, args);
    }

}
