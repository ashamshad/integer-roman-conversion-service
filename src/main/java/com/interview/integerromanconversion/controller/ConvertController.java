package com.interview.integerromanconversion.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConvertController {

	@PostMapping("/convert/integer")
	public String convertInteger(@RequestParam Integer integer) {
		System.out.println(integer + " to be converted");
		return "roman";
	}
}
