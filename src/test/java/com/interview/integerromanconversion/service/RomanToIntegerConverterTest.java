package com.interview.integerromanconversion.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanToIntegerConverterTest {

    @Test
    public void convert_nominal_returnsConvertedValue() {
        //GIVEN
        String testValue = "roman";

        //WHEN
        RomanToIntegerConverter converter = new RomanToIntegerConverter();
        Integer integer = converter.convert(testValue);

        //THEN
        assertEquals(0, integer);
    }
}
