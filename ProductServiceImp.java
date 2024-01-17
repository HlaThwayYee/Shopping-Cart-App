package com.th.SpringBoot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductServiceImp implements IProductService {
	@Autowired
	ProductRepositoryInterface repo;

	@Override
	public List<Product> getAllProduct() {
		return repo.findAll();
	}

	@Override
	public Product getProductById(String id) {
		return repo.getById(id);
	}

}
