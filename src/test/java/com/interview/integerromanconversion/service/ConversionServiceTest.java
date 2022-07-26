package com.interview.integerromanconversion.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConversionServiceTest {

    @Test
    public void integerToRoman_singleDigit_returnsRoman() {
        //GIVEN
        int testInt = 1;

        //WHEN
        ConversionService conversionService = new ConversionService();
        String roman = conversionService.integerToRoman(testInt);

        //THEN
        assertEquals("I", roman);
    }

    @Test
    public void integerToRoman_doubleDigit_returnsRoman() {
        //GIVEN
        int testInt = 13;

        //WHEN
        ConversionService conversionService = new ConversionService();
        String roman = conversionService.integerToRoman(testInt);

        //THEN
        assertEquals("XIII", roman);
    }
}
