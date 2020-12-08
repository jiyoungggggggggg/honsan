package com.sp.app.company;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("company.companyController")
@RequestMapping("/company/*")
public class CompanyController {
	@RequestMapping(value="info")
	public String info(Model model) throws Exception {
		return ".company.info";
	}
	
}
