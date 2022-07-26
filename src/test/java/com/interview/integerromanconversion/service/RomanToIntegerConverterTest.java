package com.interview.integerromanconversion.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanToIntegerConverterTest {

    @Test
    public void convert_invalidRomanCharacter_throwsIllegalArgumentException() {
        //GIVEN
        String testValue = "roman";

        //WHEN
        RomanToIntegerConverter converter = new RomanToIntegerConverter();
        IllegalArgumentException exception =
                Assertions.assertThrows(IllegalArgumentException.class, () -> converter.convert(testValue));

        //THEN
        assertEquals(
                "Roman character r is not allowed. Characters allowed are: ['M','D','C','L','X','V','I']",
                exception.getMessage()
        );
    }

    @Test
    public void convert_singleRomanCharacter_returnsConvertedInt() {
        //GIVEN
        String testRomanValue = "M";

        //WHEN
        RomanToIntegerConverter converter = new RomanToIntegerConverter();
        Integer integer = converter.convert(testRomanValue);

        //THEN
        assertEquals(1000, integer);
    }

    @Test
    public void convert_twoRomanCharacters_returnsConvertedInt() {
        //GIVEN
        String testRomanValue = "DC";

        //WHEN
        RomanToIntegerConverter converter = new RomanToIntegerConverter();
        Integer integer = converter.convert(testRomanValue);

        //THEN
        assertEquals(600, integer);
    }
    
}
