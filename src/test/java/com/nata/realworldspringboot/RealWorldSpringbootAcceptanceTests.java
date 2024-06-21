package com.nata.realworldspringboot;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nata.realworldspringboot.users.UserDto;
import com.nata.realworldspringboot.users.UserRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class RealWorldSpringbootAcceptanceTests {

    @Autowired
    private MockMvc mvc;

    @Test
    void should_register_a_user() throws Exception {
        String email = "elpepe@test.com";
        String username = "ElManu";
        var userRequest = new UserRequest(new UserDto(username,
                email,
                "password"));
        ObjectMapper objectMapper = new ObjectMapper();
        var result = mvc.perform(post("/users")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(userRequest)))
                .andExpect(status().isCreated())
                .andReturn();

        Assertions.assertTrue(result.getResponse().getContentAsString().contains("\"email\": \"elpepe@test.com\""));
    }

}
