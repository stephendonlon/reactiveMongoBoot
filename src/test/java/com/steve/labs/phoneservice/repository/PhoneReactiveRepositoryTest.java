package com.steve.labs.phoneservice.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.steve.labs.phoneservice.PhoneServiceApplication;
import com.steve.labs.phoneservice.domain.Phone;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = PhoneServiceApplication.class)
public class PhoneReactiveRepositoryTest {

  @Autowired
  PhoneReactiveRepository repository;

  @Test
  public void findAllPhonesShouldReturnAllPhones() {
    repository.save(new Phone("1", "iPhone", "Apple")).block();
    Flux<Phone> phoneFlux = repository.findAll(Example.of(new Phone(null, "iPhone", null)));

    StepVerifier
        .create(phoneFlux)
        .assertNext(phone -> {
          assertEquals("1", phone.getId());
          assertEquals("iPhone", phone.getModel());
          assertEquals("Apple", phone.getMake());
        })
        .expectComplete()
        .verify();
  }

  @Test
  public void findPhoneByIdShouldReturnPhone() {
    Phone iPhone = repository.save(new Phone(null, "iPhone", "Apple")).block();
    Mono<Phone> accountMono = repository.findById(iPhone.getId());

    StepVerifier
        .create(accountMono)
        .assertNext(phone -> {
          assertEquals("iPhone", phone.getModel());
          assertEquals("Apple", phone.getMake());
          assertNotNull(phone.getId());
        })
        .expectComplete()
        .verify();
  }
}
