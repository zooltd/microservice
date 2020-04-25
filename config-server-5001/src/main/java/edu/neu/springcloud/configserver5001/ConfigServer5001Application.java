package edu.neu.springcloud.configserver5001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigServer5001Application {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServer5001Application.class, args);
    }

}
