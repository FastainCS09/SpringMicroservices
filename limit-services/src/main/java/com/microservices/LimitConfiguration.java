package com.microservices;

import lombok.Data;

@Data
public class LimitConfiguration {
  private final  int maximum;
  private final int minimum;
}
