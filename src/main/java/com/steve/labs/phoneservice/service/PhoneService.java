package com.steve.labs.phoneservice.service;

import com.steve.labs.phoneservice.domain.Phone;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PhoneService {

  Mono<Phone> findById(String id);

  Flux<Phone> findAll();

  Mono<Phone> save(Phone phone);
}
