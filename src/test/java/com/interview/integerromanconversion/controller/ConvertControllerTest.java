package com.interview.integerromanconversion.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ConvertControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void convertInteger_nominalScenario_returnsConvertedText() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/convert/integer").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
