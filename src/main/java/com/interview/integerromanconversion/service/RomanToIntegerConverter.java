package com.interview.integerromanconversion.service;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class RomanToIntegerConverter implements Converter<String, Integer> {

    public Integer convert(String roman) {
        return 0;
    }
}
