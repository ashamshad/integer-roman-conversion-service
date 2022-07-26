package com.interview.integerromanconversion.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntegerToRomanConverterTest {

    @Test
    public void integerToRoman_singleDigit_returnsRoman() {
        //GIVEN
        int testInt = 1;

        //WHEN
        IntegerToRomanConverter integerToRomanConverter = new IntegerToRomanConverter();
        String roman = integerToRomanConverter.convert(testInt);

        //THEN
        assertEquals("I", roman);
    }

    @Test
    public void integerToRoman_doubleDigits_returnsRoman() {
        //GIVEN
        int testInt = 13;

        //WHEN
        IntegerToRomanConverter integerToRomanConverter = new IntegerToRomanConverter();
        String roman = integerToRomanConverter.convert(testInt);

        //THEN
        assertEquals("XIII", roman);
    }

    @Test
    public void integerToRoman_tripleDigits_returnsRoman() {
        //GIVEN
        int testInt = 125;

        //WHEN
        IntegerToRomanConverter integerToRomanConverter = new IntegerToRomanConverter();
        String roman = integerToRomanConverter.convert(testInt);

        //THEN
        assertEquals("CXXV", roman);
    }

    @Test
    public void integerToRoman_fourDigits_returnsRoman() {
        //GIVEN
        int testInt = 1234;

        //WHEN
        IntegerToRomanConverter integerToRomanConverter = new IntegerToRomanConverter();
        String roman = integerToRomanConverter.convert(testInt);

        //THEN
        assertEquals("MCCXXXIV", roman);
    }

    @Test
    public void integerToRoman_testingMaxRomanNumber_returnsRoman() {
        //GIVEN
        int testInt = 3999;

        //WHEN
        IntegerToRomanConverter integerToRomanConverter = new IntegerToRomanConverter();
        String roman = integerToRomanConverter.convert(testInt);

        //THEN
        assertEquals("MMMCMXCIX", roman);
    }

    @Test
    public void romanToInteger_() {
        //GIVEN

        //WHEN

        //THEN
    }
}
