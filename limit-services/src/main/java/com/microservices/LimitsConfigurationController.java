package com.microservices;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

  @Autowired
  private Configuration configuration;

  @GetMapping("/limits")
  public LimitConfiguration retrieveLimitsConfigurations(){
      return new LimitConfiguration(configuration.getMaximum(),configuration.getMinimum());
  }

  @GetMapping("/fault-tolerance")
  @HystrixCommand(fallbackMethod = "fallBackretrieveLimitsConfigurations")
  public LimitConfiguration retrieveConfigurations() throws RuntimeException {
    throw new RuntimeException("not available");
  }

  public LimitConfiguration fallBackretrieveLimitsConfigurations() throws RuntimeException {
    return new LimitConfiguration(1000, 99);
  }
}
