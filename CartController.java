package com.th.SpringBoot;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping("/cart")
public class CartController {
	@PostMapping("/addtocart")
	public String addtocart(HttpServletRequest request,HttpSession session, @ModelAttribute Product product) {
		//Save purchase data to Item
		Item item=new Item();
		item.setItemID(product.getItemID());
		System.out.println(product.getItemID());
		item.setBrandname(product.getBrandname());
		item.setPrice(product.getPrice());
		item.setQty(Integer.parseInt(request.getParameter("qty")));
		double amount=product.getPrice()*Integer.parseInt(request.getParameter("qty"));
		item.setAmount(amount);
		
		//save purchase data to Cart and Session object 
		Cart sesscart=(Cart)(session.getAttribute("cart"));
		 if (sesscart==null) {
			 Cart cart=new Cart();
			 cart.addItem(item);
			 session.setAttribute("cart",cart);
		}
		 else {
			 Cart cart=(Cart)(session.getAttribute("cart"));
			 cart.addItem(item);
			 session.setAttribute("cart",cart);
		 }
	   
		return "redirect:viewcart";
	}
	
	@GetMapping("/viewcart")
	public String viewCart(HttpServletRequest request,Model model) 
	{
		Cart cart=new Cart();
		List<Item> list=cart.viewcartdata(request);
        model.addAttribute("list", list);
        //call CalculateCartTotal()
        cart.CalculateCartTotal(request);
		return "viewcart";
	}
	
	@GetMapping("/removeById")
	public String removeById(HttpSession session,HttpServletRequest request,@RequestParam String id) {
		
		Cart sesscart=(Cart)(session.getAttribute("cart"));
		Item item=new Item();
		item=(Item)sesscart.getItemById(id);
		sesscart.removeItem(item);
		session.setAttribute("cart",sesscart);
		return "redirect:viewcart";
	
	}
}
