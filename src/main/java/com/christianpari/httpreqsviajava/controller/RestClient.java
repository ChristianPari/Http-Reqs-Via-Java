package com.christianpari.httpreqsviajava.controller;

import com.christianpari.httpreqsviajava.entity.Contact;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RestClient {

  private static final String GET_ALL_CONTACTS = "http://localhost:8080/api/v1/getAllContacts";
  private static final String GET_CONTACT = "http://localhost:8080/api/v1/getContactByID/{id}";
  private static final String CREATE_CONTACT = "http://localhost:8080/api/v1/addContact";
  private static final String DELETE_CONTACT = "http://localhost:8080/api/v1/deleteContact/{id}";

  static RestTemplate restTemplate = new RestTemplate();

  public static void main(String[] args) {
//    callGetAllContactsAPI();
//    callGetContactByIdAPI();
//    callCreateContactAPI();
//    callGetAllContactsAPI();
    callDeleteContactByIdAPI();
  }

  private static void callGetAllContactsAPI() {
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

    HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

    ResponseEntity<String> response = restTemplate.exchange(GET_ALL_CONTACTS, HttpMethod.GET, entity, String.class);

    System.out.println(response);
  }

  private static void callGetContactByIdAPI() {
    Map<String, String> param = new HashMap<>();
    param.put("id", "3683cb3a-56ba-451d-85f8-60d23894eb00");

    Contact contact =  restTemplate.getForObject(GET_CONTACT, Contact.class, param);
    System.out.println(contact.name);
    System.out.println(contact.phone);
    System.out.println(contact.fax);
    System.out.println(contact.address);
    System.out.println(contact.company);
  }

  private static void callCreateContactAPI() {
    Contact contact = new Contact("Tester", "1011011011", "1001001111", "Testing HQ", "Testing Street");

    ResponseEntity<Contact> createdContact = restTemplate.postForEntity(CREATE_CONTACT, contact, Contact.class);

    System.out.println(createdContact.getBody());
  }

  private static void callDeleteContactByIdAPI() {
    Map<String, String> param = new HashMap<>();
    param.put("id", "e908d873-5166-479d-bbb1-8f5e6356a7b0");
    restTemplate.delete(DELETE_CONTACT, param);
  }
}
