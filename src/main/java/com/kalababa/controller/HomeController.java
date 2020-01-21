package com.kalababa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kalababa.model.Product;
import com.kalababa.model.Queries;
import com.kalababa.product.model.CameraMaster;
import com.kalababa.product.model.CategoryMaster;
import com.kalababa.product.model.LaptopMaster;
import com.kalababa.product.model.ProductMaster;
import com.kalababa.product.model.TVMaster;
import com.kalababa.product.service.ProductService;
import com.kalababa.service.QueriesService;



@Controller
public class HomeController {
	
	@Autowired
	private ProductService prodService;
	
	@RequestMapping({ "/index", "/index1", "/"})
	public String sayIndex(Model model, HttpServletRequest req) {
		initHomePage(model);
		/*String uri = req.getRequestURI();
		if(uri.contains("index1"))
			return "index1";*/
		return "home";
	}
	
	/*@RequestMapping({ "/*" })
	public String sayHomePage(Model model) {
		initHomePage(model);
		return "index";
	}*/

	private void initHomePage(Model model) {
		List<CategoryMaster> categoryList = prodService.findAllCategories();
		model.addAttribute("categoryList", categoryList);
		List<LaptopMaster> listLaptop = prodService.findAllLaptops();
		model.addAttribute("laptopList", listLaptop);
		List<TVMaster> listTV = prodService.findAllTV();
		model.addAttribute("tvList", listTV);
		List<CameraMaster> listCam = prodService.findAllCamera();
		model.addAttribute("camList", listCam);
		List<ProductMaster> listProd = prodService.findAllProducts();
		model.addAttribute("prodList", listProd);
		List<Product> items = prodService.findAllItems();
		model.addAttribute("items", items);
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
