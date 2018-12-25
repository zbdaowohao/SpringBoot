package com.ads.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ads.model.UserModel;
import com.ads.service.UserService;
import com.ads.utils.IOUtils;

@Controller
public class WelcomeController {

	private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/login" })
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = { "/toLogin" })
	@ResponseBody
	public Map<String,String> toLogin(HttpServletRequest request) {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		UserModel user = new UserModel();
		user.setUserName(userName);
		user.setPassword(password);
		Map<String,String> resultMap = new HashMap<String,String>();
		try {
			String userId = userService.findByUser(user);
			if(!StringUtils.isBlank(userId)){
				resultMap.put("result", "success");
				resultMap.put("userId", userId);
			}else{
				resultMap.put("msg", "User name or password incorrect !");
			}
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return resultMap;
	}

	@RequestMapping(value = { "/home" })
	public String home() {
		return "home";
	}

	@RequestMapping(value = { "/signIn" })
	public String signIn() {
		return "signIn";
	}

	@RequestMapping(value = { "/toSignIn" })
	@ResponseBody
	public Map<String, String> toSignIn(HttpServletRequest request) {
		String username = request.getParameter("userName");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String password = request.getParameter("password");
		String country = request.getParameter("country");
		String state = request.getParameter("state");

		UserModel model = new UserModel();
		model.setUserName(username);
		model.setEmail(email);
		model.setTel(tel);
		model.setPassword(password);
		model.setCountry(country);
		model.setState(state);
		Map<String, String> resultMap = new HashMap<String, String>();
		try {
			int count = userService.count(model);
			if (count == 0) {
				userService.addUser(model);
				resultMap.put("result", "success");
			} else {
				resultMap.put("result", "failed");
				resultMap.put("msg", "This userName has already been used !");
			}
		} catch (Exception e) {
			resultMap.put("result", "failed");
			resultMap.put("msg", "Unknown error occured...");
			logger.error(e.toString());
		}
		return resultMap;
	}
	
	@RequestMapping("associateName")
	@ResponseBody
	public String associateName(HttpServletRequest request){
		String userName = request.getParameter("userName");
		try {
			String name = userService.findByUserName(userName);
			return !StringUtils.isBlank(name)?name:"";
		} catch (Exception e) {
			logger.error(e.toString());
			return "";
		}
	}
	
	@RequestMapping("readBrifeIntroduceg")
	@ResponseBody
	public String readBrifeIntroduceg(HttpServletRequest request){
		return IOUtils.readText("text/brifeIntroduce.txt");
	}
	
	@RequestMapping("readWorkingExperience")
	@ResponseBody
	public String readWorkingExperience(HttpServletRequest request){
		return IOUtils.readText("text/workingExperience.txt");
	}
	
	@RequestMapping("readProjectIntroduction")
	@ResponseBody
	public String readProjectIntroduction(HttpServletRequest request){
		return IOUtils.readText("text/projectIntroduction.txt");
	}
	
	@RequestMapping("readCareerPlanning")
	@ResponseBody
	public String readCareerPlanning(HttpServletRequest request){
		return IOUtils.readText("text/careerPlanning.txt");
	}

}
