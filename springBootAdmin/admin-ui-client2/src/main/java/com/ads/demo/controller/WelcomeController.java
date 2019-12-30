package com.ads.demo.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@RequestMapping(value = "welcome", method = RequestMethod.GET)
	public String welcomeGet(@RequestParam String name) {
		return "this is get method, author : " + name;
	}

	@RequestMapping(value = "welcome", method = RequestMethod.POST)
	public String welcomePost(@RequestBody String name) {
		return "this is post method, author : " + name;
	}

}
