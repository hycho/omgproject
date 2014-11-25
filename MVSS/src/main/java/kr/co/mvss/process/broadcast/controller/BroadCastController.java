package kr.co.mvss.process.broadcast.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BroadCastController {
	
	private static final Logger logger = LoggerFactory.getLogger(BroadCastController.class);
	
	@RequestMapping(value = "/getBest5Drama", method = RequestMethod.GET)
	public String getBest5Drama() {
		logger.info("Call Best5Drama");
		
		return "home";
	}
}
