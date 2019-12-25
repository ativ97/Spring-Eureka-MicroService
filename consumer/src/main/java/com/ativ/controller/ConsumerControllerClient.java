package com.ativ.controller;

import com.ativ.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class ConsumerControllerClient {
  @Autowired
  private DiscoveryClient discoveryClient;
  private static HttpEntity<?> getHeaders() throws IOException {
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    return new HttpEntity<>("parameters",headers);
  }

  public void getEmployee() throws RestClientException, IOException {

    List<ServiceInstance> instances=discoveryClient.getInstances("employee-producer");
    ServiceInstance serviceInstance=instances.get(0);

    String baseUrl=serviceInstance.getUri().toString()+ "/employees";
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<Employee[]> response = null;
    try {
      response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), Employee[].class);
      for (int i = 0; i<response.getBody().length;i++) {
        System.out.println(response.getBody()[i].toString());
      }
    } catch (Exception ex) {
      System.out.println(ex.toString());
    }
  }
}
