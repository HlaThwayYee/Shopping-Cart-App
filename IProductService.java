package com.th.SpringBoot;

import java.util.List;

public interface IProductService {
	public List<Product> getAllProduct();
    public Product getProductById(String id);

}
