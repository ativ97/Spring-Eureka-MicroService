package com.ativ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProducerApp {

  public static void main(String[] args) {
    SpringApplication.run(ProducerApp.class, args);
  }
}
