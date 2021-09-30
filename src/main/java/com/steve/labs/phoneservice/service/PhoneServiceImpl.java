package com.steve.labs.phoneservice.service;

import com.steve.labs.phoneservice.domain.Phone;
import com.steve.labs.phoneservice.repository.PhoneReactiveRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PhoneServiceImpl implements PhoneService {

  private final PhoneReactiveRepository phoneReactiveRepository;

  public PhoneServiceImpl(PhoneReactiveRepository phoneReactiveRepository) {
    this.phoneReactiveRepository = phoneReactiveRepository;
  }

  @Override
  public Mono<Phone> findById(String id) {
    return phoneReactiveRepository.findById(id);
  }

  @Override
  public Flux<Phone> findAll() {
    return phoneReactiveRepository.findAll();
  }

  @Override
  public Mono<Phone> save(Phone phone) {
    return phoneReactiveRepository.save(phone);
  }

}
