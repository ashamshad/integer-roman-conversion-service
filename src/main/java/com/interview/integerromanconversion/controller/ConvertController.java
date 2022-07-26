package com.interview.integerromanconversion.controller;

import com.interview.integerromanconversion.converter.IntegerToRomanConverter;
import com.interview.integerromanconversion.converter.RomanToIntegerConverter;
import com.interview.integerromanconversion.domain.ConvertResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

@Validated
@RestController
public class ConvertController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

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
	public String convertInteger(
			@RequestParam("integer")
			@Max(3999)
			Integer integer) {
		logger.info(integer + " to be converted");
		return this.integerToRomanConverter.convert(integer);
	}

	@PostMapping("/convert/roman")
	public ConvertResponse convertRoman(
			@RequestParam
			@Pattern(regexp = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$")
			String text) {
		logger.info(text + " to be converted");
		Integer convertedInteger = this.romanToIntegerConverter.convert(text);
		return new ConvertResponse(String.valueOf(convertedInteger));
	}
}
