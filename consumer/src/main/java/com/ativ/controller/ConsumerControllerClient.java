package com.ativ.controller;

import com.ativ.model.Employee;
import org.springframework.http.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class ConsumerControllerClient {

  private static HttpEntity<?> getHeaders() throws IOException {
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    return new HttpEntity<>("parameters",headers);
  }

  public void getEmployee() throws RestClientException, IOException {

    String baseUrl = "http://localhost:8081/employees";
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
