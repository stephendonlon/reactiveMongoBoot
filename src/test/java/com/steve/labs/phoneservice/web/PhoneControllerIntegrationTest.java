package com.steve.labs.phoneservice.web;

import static org.mockito.BDDMockito.given;

import com.steve.labs.phoneservice.PhoneServiceApplication;
import com.steve.labs.phoneservice.domain.Phone;
import com.steve.labs.phoneservice.repository.PhoneReactiveRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes= PhoneServiceApplication.class)
public class PhoneControllerIntegrationTest {

  @MockBean
  private PhoneReactiveRepository phoneReactiveRepository;

  @Autowired
  private WebTestClient webTestClient;

  @Test
  public void getPhoneByIdShouldReturnCorrectPhone() {

    Phone iPhone = Phone.builder()
        .id("1")
        .make("Apple")
        .model("iPhone")
        .build();

    given(phoneReactiveRepository.findById("1")).willReturn(Mono.just(iPhone));

    webTestClient.get()
        .uri("/phone/1")
        .exchange()
        .expectStatus()
        .isOk()
        .expectBody(Phone.class)
        .isEqualTo(iPhone);
  }



}
