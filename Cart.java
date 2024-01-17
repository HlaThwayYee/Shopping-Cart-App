package com.th.SpringBoot;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Cart {

	private List<Item> list = new ArrayList<Item>();

	public Cart() {
	}

	public void addItem(Item item) {
		list.add(item);
	}

	public void removeItem(Item item) {
		list.remove(item);
	}

	public List<Item> getAllItem() {
		return list;
	}

	public Item getItemById(String id) {
		Item item = null;
		for (Item ite : list) {
			if (ite.getItemID().equals(id)) {
				item = ite;
				break;
			}
		}
		return item;
	}

	public List<Item> viewcartdata(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Cart sesscart = (Cart) (session.getAttribute("cart"));
		List<Item> list = (List<Item>) sesscart.getAllItem();
		return list;

	}

	public void CalculateCartTotal(HttpServletRequest request) {
		HttpSession cartsession = request.getSession();
		int total = 0;
		List<Item> list = viewcartdata(request);
		//if (list.isEmpty()) {
			total = list.stream().filter((p) -> p.getQty() > 0).mapToInt(p -> p.getQty()).sum();
		//}
		cartsession.setAttribute("cartqty", total);

	}

	
}
