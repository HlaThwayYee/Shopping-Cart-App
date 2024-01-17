package com.th.SpringBoot;

import java.util.List;

public interface IOrderService {
	public Orders saveOrder(Orders order);
	 public List<Orders> getAllOrders();
   
}
