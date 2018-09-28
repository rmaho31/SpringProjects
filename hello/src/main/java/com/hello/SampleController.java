package com.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class SampleController {
	
	public static void main(String[] args) {
		SpringApplication.run(SampleController.class, args);

	}

	@RequestMapping("hi")
	@ResponseBody
	String home(@RequestParam String name) {
		if(name!=null&&!name.equals("")) {
			return "Hello" + name;
		}
		return "Hello Java BootCamp";
	}
	
	@RequestMapping("logon")
	@ResponseBody
	String logon(@RequestParam String uname, @RequestParam String password) {
		return "Logon attempted: uname = " + uname + ", pwd = " + password;
	}
}
