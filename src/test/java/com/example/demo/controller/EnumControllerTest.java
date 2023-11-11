package com.example.demo.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(EnumController.class)
public class EnumControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getWithEnum_whenPriorityIsPresent_thenReturnOKWithPriority() throws Exception {
        mockMvc.perform(get("/enum?priority=中")).andExpect(status().isOk())
                .andExpect(content().string(containsString("Priority is:")));
    }

    @Test
    public void getWithEnum_whenPriorityIsNotPresent_thenReturnOKWithNoParams() throws Exception {
        mockMvc.perform(get("/enum")).andExpect(status().isOk())
                .andExpect(content().string("No params given."));
    }

    @Test
    public void getWithEnum_whenPriorityIsInvalid_thenReturnWithNoParams() throws Exception {
        mockMvc.perform(get("/enum?priority=invalid"))
                // .andExpect(status().isBadRequest());
                .andExpect(content().string("No params given."));
    }
}
