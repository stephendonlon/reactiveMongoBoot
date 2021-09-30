package com.steve.labs.phoneservice.web;

import com.steve.labs.phoneservice.domain.Phone;
import com.steve.labs.phoneservice.service.PhoneService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/phone")
public class PhoneController {

  private final PhoneService phoneService;

  public PhoneController(PhoneService phoneService) {
    this.phoneService = phoneService;
  }

  @GetMapping("/{id}")
  private Mono<Phone> getPhoneById(@PathVariable String id) {
    return phoneService.findById(id);
  }

  @GetMapping
  private Flux<Phone> getAllPhones() {
    return phoneService.findAll();
  }

  @PostMapping
  private Mono<Phone> createPhone(@RequestBody Phone phone) {
    return phoneService.save(phone);
  }

}
