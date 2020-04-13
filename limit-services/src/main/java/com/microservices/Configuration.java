package com.microservices;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limit.services")
@Data
public class Configuration {
  private int maximum;
  private int minimum;
}
