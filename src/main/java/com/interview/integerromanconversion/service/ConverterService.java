package com.interview.integerromanconversion.service;

import com.interview.integerromanconversion.converter.IntegerToRomanConverter;
import com.interview.integerromanconversion.converter.RomanToIntegerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class ConverterService {

    private Converter<Integer, String> integerToRomanConverter;
    private Converter<String, Integer> romanToIntegerConverter;

    @Autowired
    public ConverterService(
            IntegerToRomanConverter integerToRomanConverter,
            RomanToIntegerConverter romanToIntegerConverter) {
        this.integerToRomanConverter = integerToRomanConverter;
        this.romanToIntegerConverter = romanToIntegerConverter;
    }

    public String convertIntegerToRoman(Integer integer) {
        return this.integerToRomanConverter.convert(integer);
    }

    public Integer convertRomanToInteger(String roman) {
        return this.romanToIntegerConverter.convert((roman));
    }
}
