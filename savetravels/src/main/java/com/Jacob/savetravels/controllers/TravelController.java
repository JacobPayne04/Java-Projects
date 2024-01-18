package com.Jacob.savetravels.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Jacob.savetravels.models.Travel;
import com.Jacob.savetravels.services.TravelService;

import jakarta.validation.Valid;

@Controller
public class TravelController {

	private final TravelService travelServ;

	public TravelController(TravelService travelServ) {
		this.travelServ = travelServ;
	}

	@GetMapping("/expenses")
	public String showAllTravel(@ModelAttribute("travel") Travel travel, Model model,
			@RequestParam(value = "searchValue", required = false) String searchValue) {
		model.addAttribute("AllTravel", travelServ.getAll());
		return "Home.jsp";
	}

	@PostMapping("/expenses/process/new")
	public String createTravel(@Valid @ModelAttribute("travel") Travel newTravel, BindingResult result) {
		if (result.hasErrors()) {
			return "Home.jsp";
		}

		travelServ.create(newTravel);
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses/show/{id}")
	public String showOneTravel(@PathVariable("id") Long id, Model model) {
		model.addAttribute("oneTravel", travelServ.getOne(id));
		return "showOne.jsp";
	}

	@GetMapping("/expenses/edit/{id}")
	public String editTravel(@PathVariable("id") Long id, Model model) {
		model.addAttribute("travel", travelServ.getOne(id));
		return "edit.jsp";
	}

	@PatchMapping("/expenses/process/edit/{id}")
	public String processEditTravel(@Valid @ModelAttribute("travel") Travel travel, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		}
		travelServ.edit(travel);
		return "redirect:/expenses";
	}
	
	@DeleteMapping("/expenses/delete/{id}")
	public String deleteDonation(@PathVariable("id") Long id) {
		travelServ.Delete(id);
		return "redirect:/expenses";
	}
	
}
