package com.steve.labs.phoneservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Value
@Builder
@AllArgsConstructor
public class Phone {

  @Id
  String id;
  String model;
  String make;

}
