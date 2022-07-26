package com.interview.integerromanconversion.service;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RomanToIntegerConverter implements Converter<String, Integer> {

    private final static Map<Character,Integer> ROMAN_TO_INT_MAP = new HashMap<>();
    static {
        ROMAN_TO_INT_MAP.put('I', 1);
        ROMAN_TO_INT_MAP.put('V', 5);
        ROMAN_TO_INT_MAP.put('X', 10);
        ROMAN_TO_INT_MAP.put('L', 50);
        ROMAN_TO_INT_MAP.put('C', 100);
        ROMAN_TO_INT_MAP.put('D', 500);
        ROMAN_TO_INT_MAP.put('M', 1000);
    }

    public Integer convert(String roman) {
        int result = 0;

        for (int i = 0; i < roman.length(); i++) {

            char currentRomanChar = roman.charAt(i);

            if (i > 0) {
                char previousRomanChar = roman.charAt(i);
                // If the previous character is greater than the current one
                if (ROMAN_TO_INT_MAP.get(currentRomanChar) > ROMAN_TO_INT_MAP.get(previousRomanChar)) {
                    result += ROMAN_TO_INT_MAP.get(currentRomanChar) - 2 * ROMAN_TO_INT_MAP.get(previousRomanChar);
                }
            } else {
                result += ROMAN_TO_INT_MAP.get(currentRomanChar);
            }
        }

        return result;
    }
}
