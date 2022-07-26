package com.interview.integerromanconversion.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConvertController {

	@PostMapping("/convert/integer")
	public String convertInteger() {
		return "Greetings from Spring Boot!";
	}

}
