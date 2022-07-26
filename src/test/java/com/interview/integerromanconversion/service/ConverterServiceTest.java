package com.interview.integerromanconversion.service;

import com.interview.integerromanconversion.converter.IntegerToRomanConverter;
import com.interview.integerromanconversion.converter.RomanToIntegerConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ConverterServiceTest {

    @Mock
    private IntegerToRomanConverter integerToRomanConverter;
    @Mock
    private RomanToIntegerConverter romanToIntegerConverter;

    @Test
    public void convertIntegerToRoman_nominal_returnsRoman() {
        //GIVEN
        int testIntValue = 1;

        //WHEN
        ConverterService converterService = new ConverterService(integerToRomanConverter, romanToIntegerConverter);
        String result = converterService.convertIntegerToRoman(testIntValue);

        //THEN
        assertEquals("", result);
    }

    @Test
    public void convertRomanToInteger_nominal_returnsInteger() {
        //GIVEN
        String testRomanValue = "roman";

        //WHEN
        ConverterService converterService = new ConverterService(integerToRomanConverter, romanToIntegerConverter);
        Integer result = converterService.convertRomanToInteger(testRomanValue);

        //THEN
        assertEquals(0, result);
    }
}
