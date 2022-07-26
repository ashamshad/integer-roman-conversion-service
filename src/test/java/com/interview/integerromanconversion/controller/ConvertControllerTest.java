package com.interview.integerromanconversion.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.interview.integerromanconversion.converter.IntegerToRomanConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
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
    private IntegerToRomanConverter integerToRomanConverter;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void clear() {
        Mockito.reset(integerToRomanConverter);
    }

    @Test
    public void convertInteger_nominalScenario_returnsConvertedInteger() throws Exception {
        when(integerToRomanConverter.convert(10)).thenReturn("converted");
        mvc.perform(MockMvcRequestBuilders.post("/convert/integer?integer=10").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("converted")));
    }

    @Test
    public void convertInteger_missingIntegerRequestParameter_returnsError() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/convert/integer").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void convertInteger_invalidInteger_returnsError() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/convert/integer?integer=1000000").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void convertRoman_invalidRomanCharacter_returnsBadRequest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/convert/roman?text=ZZZ").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void convertRoman_invalidRepetitionOfRomanCharacters_returnsBadRequest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/convert/roman?text=MMMM").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
