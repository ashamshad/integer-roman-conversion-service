package com.interview.integerromanconversion.service;

import org.springframework.stereotype.Service;

import java.util.TreeMap;

@Service
public class ConversionService {

    private final static TreeMap<Integer, String> map = new TreeMap<>();
    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    public String integerToRoman(int number) {
        // Returns the greatest key less than or equal to the given key
        int floor = map.floorKey(number);
        if (number == floor) {
            // We've reached the end of the number to convert, so we get out of the recursive loop and return the String
            return map.get(number);
        }

        // There's still a leftover to convert, so recursively calling the function by subtracting the key found in map
        return map.get(floor) + integerToRoman(number-floor);
    }
}
