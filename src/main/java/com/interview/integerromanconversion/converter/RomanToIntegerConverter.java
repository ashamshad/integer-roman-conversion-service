package com.interview.integerromanconversion.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
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

            try {
                // If current roman character value is greater than the previous one
                if (i > 0 && isRomanCharacterGreater(currentRomanChar, roman.charAt(i-1))) {
                    result += ROMAN_TO_INT_MAP.get(currentRomanChar) - 2 * ROMAN_TO_INT_MAP.get(roman.charAt(i-1));
                } else {
                    result += ROMAN_TO_INT_MAP.get(currentRomanChar);
                }
            } catch (NullPointerException exception) {
                System.out.println("Invalid roman character found: " + currentRomanChar);
                throw new IllegalArgumentException(String.format("Roman character %s is not allowed. Characters allowed are: ['M','D','C','L','X','V','I']", currentRomanChar));
            } catch (Exception exception) {
                System.out.println("Unexpected error occurred while converting roman to integer: " + exception.getMessage());
                throw exception;
            }
        }

        return result;
    }

    private static boolean isRomanCharacterGreater(char a, char b) {
        return ROMAN_TO_INT_MAP.get(a) > ROMAN_TO_INT_MAP.get(b);
    }
}
