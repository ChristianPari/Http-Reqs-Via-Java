package com.christianpari.httpreqsviajava;

import com.christianpari.httpreqsviajava.service.RestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootApplication
public class HttpReqsViaJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HttpReqsViaJavaApplication.class, args);
	}

}
