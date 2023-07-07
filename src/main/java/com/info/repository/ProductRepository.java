package com.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.info.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	@Modifying
	@Query("UPDATE Product SET prodCode=:prodCode WHERE prodId=:prodId")
	public void updateProductCodeByProductId(String prodCode,Integer prodId);

}
