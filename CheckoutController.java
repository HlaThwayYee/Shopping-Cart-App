package com.th.SpringBoot;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/chkout")
public class CheckoutController {
	@Autowired
	private IOrderService orderservice;
	@Autowired
	private IOrderDetailService orderdetailservice;
	
	@GetMapping("/checkout")
	public String CheckOut(HttpSession session, HttpServletRequest request, Model model) {
		Cart cart=new Cart();
		List<Item> list = cart.viewcartdata(request);
		model.addAttribute("list", list);
		return "checkout";

	}

	@PostMapping("/saveOrder")
	public String saveOrder(@ModelAttribute Orders orders, HttpSession session, HttpServletRequest request,
			Model model) {

		// store form data(@ModelAttribute Orders orders) to Orders object
		Orders order = new Orders();
		order.setOrderDate(LocalDate.now());
		order.setContactName(request.getParameter("ContactName"));
		order.setAddress(request.getParameter("Address"));
		order.setPhone(request.getParameter("Phone"));
		order.setEmail(request.getParameter("Email"));
		order.setCreditCartNumber(request.getParameter("CreditCartNumber"));

		// Store orders object to database orders table using orderservice
		orderservice.saveOrder(order);
		// save orderdetails
		// To get orderid from orders table for use orderid of orderdetails
		List<Orders> olist = orderservice.getAllOrders();
		Orders od = olist.get(olist.size() - 1);
		int id = od.getId();

		// Store data to orderdeatails list object from sesssion object
		// Read data from session object
		Cart cart=new Cart();
		List<Item> list = cart.viewcartdata(request);
		System.out.println(list.size());
		List<Orderdetails> Orderdetails = new ArrayList<Orderdetails>();
		for (Item item : list) {
			Orderdetails.add(new Orderdetails(id, item.getItemID(), item.getPrice(), item.getQty(), item.getAmount()));
		}
		// Store Orderdetails list object to database orders table using
		// orderdetailservice
		orderdetailservice.saveOrderdetails(Orderdetails);
		//Clear Cart
		list.clear();
		session.setAttribute("cart",cart);
		cart.CalculateCartTotal(request);
		return "thanks";

	}
}
