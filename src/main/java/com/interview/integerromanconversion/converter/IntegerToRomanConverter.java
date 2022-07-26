package com.interview.integerromanconversion.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.TreeMap;

@Component
public class IntegerToRomanConverter implements Converter<Integer, String> {

    private final static TreeMap<Integer, String> INTEGER_ROMAN_MAP = new TreeMap<>();
    static {
        INTEGER_ROMAN_MAP.put(1000, "M");
        INTEGER_ROMAN_MAP.put(900, "CM");
        INTEGER_ROMAN_MAP.put(500, "D");
        INTEGER_ROMAN_MAP.put(400, "CD");
        INTEGER_ROMAN_MAP.put(100, "C");
        INTEGER_ROMAN_MAP.put(90, "XC");
        INTEGER_ROMAN_MAP.put(50, "L");
        INTEGER_ROMAN_MAP.put(40, "XL");
        INTEGER_ROMAN_MAP.put(10, "X");
        INTEGER_ROMAN_MAP.put(9, "IX");
        INTEGER_ROMAN_MAP.put(5, "V");
        INTEGER_ROMAN_MAP.put(4, "IV");
        INTEGER_ROMAN_MAP.put(1, "I");
    }

    public String convert(Integer number) {
        // Returns the greatest key less than or equal to the given key
        int floor = INTEGER_ROMAN_MAP.floorKey(number);
        if (number == floor) {
            // We've reached the end of the number to convert, so we get out of the recursive loop and return the String
            return INTEGER_ROMAN_MAP.get(number);
        }

        // There's still a leftover to convert, so recursively calling the function by subtracting the key found in map
        return INTEGER_ROMAN_MAP.get(floor) + convert(number-floor);
    }
}
