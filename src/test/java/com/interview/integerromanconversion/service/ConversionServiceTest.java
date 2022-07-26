package com.interview.integerromanconversion.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConversionServiceTest {

    @Test
    public void integerToRoman_nominal_returnsRoman() {
        //GIVEN
        int testInt = 10;

        //WHEN
        ConversionService conversionService = new ConversionService();
        String roman = conversionService.integerToRoman(testInt);

        //THEN
        assertEquals("roman", roman);
    }
}
