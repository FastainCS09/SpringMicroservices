package com.microservices;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Slf4j
@RestController
public class CurrencyConversionController {

  @Autowired
  private CurrencyExchangeProxy currencyExchangeProxy;

  @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
  public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
                                                @PathVariable BigDecimal quantity) {
    CurrencyConversionBean conversionBean = currencyExchangeProxy.retrieveExchangeValue(from, to);
    log.info("request -> {}",conversionBean.toString());
    return new CurrencyConversionBean(conversionBean.getId(), from, to, conversionBean.getConversionMultiple(),
        quantity, quantity.multiply(conversionBean.getConversionMultiple()), conversionBean.getPort());
  }
}
