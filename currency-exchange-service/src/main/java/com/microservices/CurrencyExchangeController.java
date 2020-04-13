package com.microservices;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CurrencyExchangeController {

  @Autowired
  private ExchangeValueRepository exchangeValueRepository;

  @Autowired
  private Environment environment;

  @GetMapping("/currency-exchange/from/{from}/to/{to}")
  public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
    ExchangeValue byFromAndTo = exchangeValueRepository.findByFromAndTo(from, to);
    log.info("request -> {}", byFromAndTo);
    byFromAndTo.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
    return byFromAndTo;

  }
}
