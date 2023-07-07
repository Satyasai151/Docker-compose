package com.info.service;

import java.util.List;

import com.info.entity.Product;

public interface IProductService {
	Integer saveProduct(Product product);

	void updateProduct(Product product);

	void deleteProduct(Integer prodId);

	Product getOneProduct(Integer prodId);

	List<Product> getAllProducts();
	
	public void updateProductCodeByProductId(String prodCode,Integer prodId);

}
