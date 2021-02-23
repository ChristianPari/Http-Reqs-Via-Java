package com.christianpari.httpreqsviajava.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {
  private final RestTemplate restTemp;

  public RestService(RestTemplateBuilder restTemplateBuilder) {
    this.restTemp = restTemplateBuilder.build();
  }

  public String getContacts() {
    String url = "http://localhost:8080/api/v1/getAllContacts";
    return this.restTemp.getForObject(url, String.class);
  }
}
