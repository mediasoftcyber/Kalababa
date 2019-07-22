package com.kalababa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kalababa.model.Queries;
import com.kalababa.product.model.CategoryMaster;
import com.kalababa.product.model.LaptopMaster;
import com.kalababa.product.service.ProductService;
import com.kalababa.service.QueriesService;



@Controller
public class HomeController {
	
	@Autowired
	private ProductService prodService;
	
	@RequestMapping({ "/index", "/index1" })
	public String sayIndex(Model model) {
		List<CategoryMaster> categoryList = prodService.findAllCategories();
		model.addAttribute("categoryList", categoryList);
		List<LaptopMaster> listLaptop = prodService.findAllLaptops();
		model.addAttribute("laptopList", listLaptop);
		return "index1";
	}

	@RequestMapping("/hello")
	public ModelAndView sayHello() {
		return new ModelAndView("hello", "hello", "Hello Mr.Prabhakar");
	}

	@RequestMapping("/login")
	public String login(/*@RequestParam(value = "error", required = false) String error,
						@RequestParam(value = "logout", required = false) String logout, Model model*/) {
		/*if (error != null && error.length()!=0)
			model.addAttribute("error", "Invalid username and Password");
		if (logout != null)
			model.addAttribute("logout", "You have logged out successfully");*/
		return "login";
	}

	@RequestMapping("/aboutus")
	public String sayAbout() {
		return "aboutUs";
	}

	@Autowired
	private QueriesService queryService;

	@RequestMapping(value = "/contactus")
	public ModelAndView getQuery() {
		Queries query = new Queries();
		return new ModelAndView("contactUs", "contact", query);
	}

	@RequestMapping(value = "/contactus", method = RequestMethod.POST)
	public String addQuery(@Valid @ModelAttribute(value = "contact") Queries query, Model model, BindingResult result) {

		if (result.hasErrors())
			return "contactUs";

		queryService.addQuery(query);
		model.addAttribute("querySuccess",
				"Thank you, Your Message stored in our Server we will contact through corresponding Mail");
		return "login";

	}
}
