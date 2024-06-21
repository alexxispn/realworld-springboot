package com.nata.realworldspringboot;

import com.fasterxml.jackson.databind.ObjectMapper;
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
    void should_create_a_user() throws Exception {
        String email = "elpepe@test.com";
        String username = "ElManu";
        var userRequest = new UserRequest(new User(username,
                email,
                "password"));
        ObjectMapper objectMapper = new ObjectMapper();
        mvc.perform(post("/users")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(userRequest)))
                .andExpect(status().isCreated())
                .andExpect(result -> result.getResponse()
                        .getContentAsString()
                        .contains(("{\n  " +
                                "\"user\": {\n" +
                                "    \"email\": \"%s\",\n" +
                                "    \"token\": \"nulasoComoUnaCasa\",\n" +
                                "    " +
                                "\"username\"\"%s\",\n" +
                                "    \"bio\": \"\",\n" +
                                "    \"image\": \"null\"\n" +
                                "  " +
                                "}\n}").formatted(email, username)));
    }

    private record User(String username, String email, String password) { }
    private record UserRequest(User user) { }
}
