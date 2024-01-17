package com.th.SpringBoot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements IOrderService{
	@Autowired
	OrderRepository repo;

	@Override
	public Orders saveOrder(Orders order) {
		return repo.save(order);
	}
	public List<Orders> getAllOrders(){
		return repo.findAll();
	}
	
	
}
