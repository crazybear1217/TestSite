package com.test.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.test.service.StripeService;
 

@Controller
public class TestHelloWorld {

	@Autowired
	StripeService stripeService;
	
	
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
		//stripeService = new StripeService();
		String stripeReulst = stripeService.stripeTest();
		String message = "<br><div align='center'>"
				+ "<h3>********** Detail: "+stripeReulst +"</h3>TestHelloWorld.java **********<br><br>";
		return new ModelAndView("welcome", "message", message);
	}
}