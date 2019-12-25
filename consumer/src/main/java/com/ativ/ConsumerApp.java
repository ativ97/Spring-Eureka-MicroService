package com.ativ;

import com.ativ.controller.ConsumerControllerClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;

import java.io.IOException;

@SpringBootApplication
public class ConsumerApp {

    public static void main(String[] args) throws RestClientException, IOException {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ConsumerControllerClient.class);
        ConsumerControllerClient consumerControllerClient=ctx.getBean(ConsumerControllerClient.class);
        consumerControllerClient.getEmployee();
    }
}
