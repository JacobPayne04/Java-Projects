//co coded with megan 


package com.Jacob.OmikujiForm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class OmikujiController {

	@PostMapping("/omikuji/process")
	public String processForm(@RequestParam("number") Integer number, @RequestParam("city") String city,@RequestParam("name") String name, @RequestParam("hobby") String hobby,@RequestParam("living") String living, @RequestParam("nice") String nice, HttpSession session) {

		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("name", name);
		session.setAttribute("hobby", hobby);
		session.setAttribute("living", living);
		session.setAttribute("nice", nice);

		return "redirect:/omikuji/show";
	}

	@GetMapping("/omikuji")
	public String main() {
		return "mainpage.jsp";
	}

	
	@GetMapping("/omikuji/show")
	public String omukujiShow() {
		return "show.jsp";
	}

}
