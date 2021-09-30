package com.steve.labs.phoneservice;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.steve.labs.phoneservice.repository.PhoneReactiveRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EnableReactiveMongoRepositories(basePackageClasses = PhoneReactiveRepository.class)
public class ReactiveMongoConfiguration extends AbstractReactiveMongoConfiguration {

  @Bean
  public MongoClient mongoClient() {
    return MongoClients.create();
  }

  @Override
  protected String getDatabaseName() {
    return "phoneDb";
  }

  @Bean
  public ReactiveMongoTemplate reactiveMongoTemplate() {
    return new ReactiveMongoTemplate(mongoClient(), getDatabaseName());
  }

}
