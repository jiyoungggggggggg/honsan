package com.sp.app.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("main.mainController")
@RequestMapping(value = "/main/*")
public class MainController {
	
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String main() {
		return ".main.main";
	}
}
