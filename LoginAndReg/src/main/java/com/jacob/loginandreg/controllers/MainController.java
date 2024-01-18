// pair programmed with megan

package com.jacob.loginandreg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jacob.loginandreg.models.LoginUser;
import com.jacob.loginandreg.models.User;
import com.jacob.loginandreg.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {

	@Autowired
	private UserService userServ;

	public MainController() {}
	
	

	@GetMapping("")
	public String loginRegUser(@ModelAttribute("user") User user, @ModelAttribute("loginUser") LoginUser loginUser, HttpSession session) {
		
		return "loginreg.jsp";
	}
	

	@PostMapping("/user/process/register")
	public String processRegister(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {

		if(userServ.getUser(user.getEmail()) != null) {
			result.rejectValue("email", "Unique", "Email already in use!");
		}

		if(!user.getPassword().equals(user.getConfirm())) {
			result.rejectValue("password", "Match", "passwords dont match");
		}

		if(result.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			return "loginreg.jsp";
		}
		User newUser = userServ.registerUser(user);
		session.setAttribute("user_id", newUser.getId());
		
		return "redirect:/welcome";
	}
	
	
	@PostMapping("/user/process/login")
	public String processLoginUser(@Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult result, Model model, HttpSession session) {
		
		User loggingUser = userServ.login(loginUser, result);
		if (result.hasErrors()) {
			model.addAttribute("user", new User());
			return "loginreg.jsp";
		}
		session.setAttribute("user_id", loggingUser.getId());
		return "redirect:/welcome";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:";
	}
	
	@GetMapping("/welcome")
	public String welcome(Model model, HttpSession session){
		if(session.getAttribute("user_id") == null) {
			return "redirect:";
		}
		model.addAttribute("oneUser", userServ.getUser((Long)session.getAttribute("user_id")));
		return "welcome.jsp";
	}

}
