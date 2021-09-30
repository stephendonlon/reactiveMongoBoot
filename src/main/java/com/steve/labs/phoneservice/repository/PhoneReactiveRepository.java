package com.steve.labs.phoneservice.repository;

import com.steve.labs.phoneservice.domain.Phone;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneReactiveRepository extends ReactiveMongoRepository<Phone, String> {

}
