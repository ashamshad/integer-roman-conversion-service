package com.interview.integerromanconversion.controller;

import com.interview.integerromanconversion.service.ConversionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ConvertControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ConversionService conversionService;

    @Test
    public void convertInteger_nominalScenario_returnsConvertedInteger() throws Exception {
        when(conversionService.integerToRoman(10)).thenReturn("converted");
        mvc.perform(MockMvcRequestBuilders.post("/convert/integer?integer=10").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("converted")));
    }
}
