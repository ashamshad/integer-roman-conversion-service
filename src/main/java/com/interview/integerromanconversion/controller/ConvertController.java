package com.interview.integerromanconversion.controller;

import com.interview.integerromanconversion.converter.IntegerToRomanConverter;
import com.interview.integerromanconversion.converter.RomanToIntegerConverter;
import com.interview.integerromanconversion.domain.ConvertIntegerRequest;
import com.interview.integerromanconversion.domain.ConvertResponse;
import com.interview.integerromanconversion.domain.ConvertRomanRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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

	@PostMapping(value = "/convert/integer", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public String convertInteger(@RequestBody @Valid ConvertIntegerRequest request) {
		logger.info(request.getInteger() + " to be converted");
		return this.integerToRomanConverter.convert(Integer.valueOf(request.getInteger()));
	}

	@PostMapping(value = "/convert/roman", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ConvertResponse convertRoman(@RequestBody @Valid ConvertRomanRequest request) {
		logger.info(request.getRoman() + " to be converted");
		Integer convertedInteger = this.romanToIntegerConverter.convert(request.getRoman());
		return new ConvertResponse(String.valueOf(convertedInteger));
	}
}
