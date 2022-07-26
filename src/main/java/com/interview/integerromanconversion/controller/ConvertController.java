package com.interview.integerromanconversion.controller;

import com.interview.integerromanconversion.domain.ConvertResponse;
import com.interview.integerromanconversion.service.IntegerToRomanConverter;
import com.interview.integerromanconversion.service.RomanToIntegerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConvertController {
	private Converter<Integer, String> integerToRomanConverter;
	private Converter<String, Integer> romanToIntegerConverter;

	@Autowired
	public ConvertController(
			IntegerToRomanConverter integerToRomanConverter,
			RomanToIntegerConverter romanToIntegerConverter) {
		this.integerToRomanConverter = integerToRomanConverter;
		this.romanToIntegerConverter = romanToIntegerConverter;
	}

	@PostMapping("/convert/integer")
	public String convertInteger(@RequestParam Integer integer) {
		System.out.println(integer + " to be converted");
		return this.integerToRomanConverter.convert(integer);
	}

	@PostMapping("/convert/roman")
	public ConvertResponse convertRoman(@RequestParam String text) {
		System.out.println(text + " to be converted");
		return new ConvertResponse("0");
	}
}
