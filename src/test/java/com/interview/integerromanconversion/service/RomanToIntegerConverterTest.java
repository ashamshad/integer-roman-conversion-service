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
}
