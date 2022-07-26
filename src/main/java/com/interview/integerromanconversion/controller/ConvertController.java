package com.interview.integerromanconversion.controller;

import com.interview.integerromanconversion.service.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConvertController {
	private ConversionService conversionService;

	@Autowired
	public ConvertController(ConversionService conversionService) {
		this.conversionService = conversionService;
	}

	@PostMapping("/convert/integer")
	public String convertInteger(@RequestParam Integer integer) {
		System.out.println(integer + " to be converted");
		return this.conversionService.integerToRoman(integer);
	}
}
