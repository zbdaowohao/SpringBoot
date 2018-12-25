package com.ads.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FTLIndexController {

	// http://127.0.0.1:8080/ftlIndex?name=houbberVan&age=25
	@RequestMapping("/ftlIndex")
	public String index(HttpServletRequest request) {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		request.setAttribute("sex", "0");
		return "ftlIndex";
	}

}
