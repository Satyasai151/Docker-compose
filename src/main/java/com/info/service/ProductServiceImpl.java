package com.info.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.entity.Product;
import com.info.exception.ProductNotFoundException;
import com.info.repository.ProductRepository;
import com.info.utils.CalculationUtils;

@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	private ProductRepository repo;

	@Override
	public Integer saveProduct(Product product) {
		CalculationUtils.blogic(product);

		repo.save(product);
		return product.getProdId();
	}

	@Override
	public void updateProduct(Product product) {
		CalculationUtils.blogic(product);
		repo.save(product);

	}

	@Override
	public void deleteProduct(Integer prodId) {
		repo.deleteById(prodId);

	}

	@Override
	public Product getOneProduct(Integer prodId) {
		Optional<Product> findById = repo.findById(prodId);
		if (findById.isPresent()) {
			return findById.get();

		} else {
			throw new ProductNotFoundException("Product " + prodId + " not exit");

		}

	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> findAll = repo.findAll();
		return findAll;
	}

	@Override
	@Transactional
	public void updateProductCodeByProductId(String prodCode, Integer prodId) {
		if(!repo.existsById(prodId)) {
			throw new ProductNotFoundException("Product " + prodId + " Not Exit");
		}
		repo.updateProductCodeByProductId(prodCode, prodId);
		
	}

}
