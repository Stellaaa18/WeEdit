package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/testController")
public class TestController {
	@RequestMapping(value = "/toTestPage")
	public Object test(Model model){
		model.addAttribute("msg", "访问该接口，可获得此参数，并前往test.jsp界面");
		return "test";
		
	}
}
