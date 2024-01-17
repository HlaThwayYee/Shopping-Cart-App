package com.th.SpringBoot;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<Orderdetails, Integer> {
	 
}
