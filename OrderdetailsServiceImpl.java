package com.th.SpringBoot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderdetailsServiceImpl implements IOrderDetailService{
	@Autowired
	OrderDetailRepository repo;

	@Override
	public void saveOrderdetails(List<Orderdetails> orderdetails) {
		
		 repo.saveAll(orderdetails);
	}
	

}