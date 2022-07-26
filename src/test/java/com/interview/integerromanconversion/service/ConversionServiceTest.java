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
    public void integerToRoman_doubleDigits_returnsRoman() {
        //GIVEN
        int testInt = 13;

        //WHEN
        ConversionService conversionService = new ConversionService();
        String roman = conversionService.integerToRoman(testInt);

        //THEN
        assertEquals("XIII", roman);
    }

    @Test
    public void integerToRoman_tripleDigits_returnsRoman() {
        //GIVEN
        int testInt = 125;

        //WHEN
        ConversionService conversionService = new ConversionService();
        String roman = conversionService.integerToRoman(testInt);

        //THEN
        assertEquals("CXXV", roman);
    }

    @Test
    public void integerToRoman_fourDigits_returnsRoman() {
        //GIVEN
        int testInt = 1234;

        //WHEN
        ConversionService conversionService = new ConversionService();
        String roman = conversionService.integerToRoman(testInt);

        //THEN
        assertEquals("MCCXXXIV", roman);
    }
}
