package com.nata.realworldspringboot.users.e2e;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nata.realworldspringboot.users.domain.User;
import com.nata.realworldspringboot.users.domain.primitives.UserPrimitives;
import com.nata.realworldspringboot.users.infrastructure.controllers.dtos.RegisterUserResponseDTO;
import com.nata.realworldspringboot.users.infrastructure.controllers.params.RegisterUserControllerParams;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.FluxExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

import static com.nata.realworldspringboot.users.mothers.UserMother.juan;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class UserRegistrationE2ETest {

  @Autowired
  private WebTestClient webTestClient;

  @Test
  void should_register_a_user() {
    User juan = juan();
    UserPrimitives juanPrimitives = juan.toPrimitives();
    RegisterUserControllerParams body = new RegisterUserControllerParams(
        juanPrimitives.userId(),
        juanPrimitives.username(),
        juanPrimitives.email(),
        juanPrimitives.password(),
        juanPrimitives.bio()
    );
    webTestClient.post().uri("/users")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(body)
        .exchange()
        .expectBody(RegisterUserResponseDTO.class)
        .consumeWith(result -> {
          RegisterUserResponseDTO response = result.getResponseBody();
          assertEquals(juanPrimitives.userId(), response.userId());
          assertEquals(juanPrimitives.bio(), response.bio());
          assertEquals(juanPrimitives.username(), response.username());
          assertEquals(juanPrimitives.email(), response.email());
        });

  }
}



