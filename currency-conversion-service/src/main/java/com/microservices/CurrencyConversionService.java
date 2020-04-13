package com.microservices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.microservices")
@EnableDiscoveryClient
public class CurrencyConversionService {
  public static void main(String[] args) {
    SpringApplication.run(CurrencyConversionService.class);
  }
}
