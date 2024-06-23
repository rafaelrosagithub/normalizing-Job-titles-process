package com.rafael.api.normalize.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class NormalizeControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testNormalizeJobTitleControllerWithJobTitle() throws Exception {
        // Perform a GET request to the endpoint with a job title and verify the response status and content
        mockMvc.perform(get("/api/v1/normalizer/Java engineer"))
                .andExpect(status().isOk())
                .andExpect(content().string("Software Engineer"));
    }

    @Test
    public void testNormalizeJobTitleControllerWithoutJobTitle() throws Exception {
        // Perform a GET request to the endpoint without a job title and verify the response status and content
        mockMvc.perform(get("/api/v1/normalizer/"))
                .andExpect(status().isOk())
                .andExpect(content().string("Job Title not specified"));
    }
}

