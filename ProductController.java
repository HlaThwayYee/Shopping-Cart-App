package com.th.SpringBoot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private IProductService service;
	//@Autowired
	//private IReportService rpservice;
     
	@GetMapping("/")
	public String showHomePage() {
		return "homePage";
	}
	
	@GetMapping("/getallproduct")
	public String allProduct(Model model) {
		List<Product> product= service.getAllProduct();
		model.addAttribute("list", product);
		return "allproduct";
	}
	
	@GetMapping("/getById")
	public String getById(Model model,@RequestParam String id) {
		Product product = service.getProductById(id);
		model.addAttribute("product" , product);
		return "shopping";
	}
	
}

