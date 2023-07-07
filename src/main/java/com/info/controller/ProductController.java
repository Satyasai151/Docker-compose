package com.info.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.info.entity.Product;
import com.info.exception.ProductNotFoundException;
import com.info.service.ProductServiceImpl;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductServiceImpl service;
	
	private static final Logger LOG=LoggerFactory.getLogger(ProductController.class);

	@PostMapping("/save")
	public ResponseEntity<String> saveProduct(@RequestBody Product product) {
		LOG.info("ENTERED SAVE METHOD");
		ResponseEntity<String> res = null;
		try {
			Integer saveProduct = service.saveProduct(product);
			String data = "Product Save Data :" + saveProduct;
			 res = new ResponseEntity<String>(data, HttpStatus.CREATED);
			 LOG.debug(data);
			
		}
		catch(Exception e) {
			LOG.error("SAVING IS FAILD{}",e.getMessage());
			e.printStackTrace();
			res=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		LOG.info("ABOUT TO LEAVE SAVING METHOD");

		return res;

	}

	@GetMapping("/all")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> allProducts = service.getAllProducts();
		ResponseEntity<List<Product>> res = new ResponseEntity<List<Product>>(allProducts, HttpStatus.OK);
		return res;

	}

	@GetMapping("/find/{prodId}")
	public ResponseEntity<?> getProductById(@PathVariable Integer prodId) {
		LOG.info("ENTERED into getting one record METHOD");
		ResponseEntity<?> res = null;
		try {
			Product oneProduct = service.getOneProduct(prodId);
			res = new ResponseEntity<Product>(oneProduct, HttpStatus.OK);

		} catch (ProductNotFoundException pe) {
			LOG.error("ONE RECORD FAILD {}" + pe.getMessage());
			pe.printStackTrace();
			res = new ResponseEntity<String>(pe.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}
		LOG.info("ABOUT TO LEAVE ONE RECORD METHOD");
		
		return res;

	}

	@DeleteMapping("/deleteById/{prodId}")
	public ResponseEntity<?> deleteOneProduct(@PathVariable Integer prodId) {
		ResponseEntity<?> res = null;
		try {
			service.deleteProduct(prodId);
			res = new ResponseEntity<String>("Product removed " + prodId, HttpStatus.OK);

		} catch (ProductNotFoundException pe) {
			pe.printStackTrace();
			res = new ResponseEntity<String>(pe.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}

		return res;

	}

	@PutMapping("/update")
	public ResponseEntity<String> productUpdate(@RequestBody Product product) {
		ResponseEntity<String> res = null;
		try {
			service.updateProduct(product);
			res = new ResponseEntity<String>("Product " + product.getProdId() + "Update", HttpStatus.OK);

		} catch (ProductNotFoundException pe) {
			pe.printStackTrace();
			res = new ResponseEntity<String>("Product Not Update", HttpStatus.INTERNAL_SERVER_ERROR);

		}

		return res;

	}

	@PatchMapping("/update/{prodId}/{prodCode}")
	public ResponseEntity<String> updateProductCodeByProductId(@PathVariable Integer prodId, @PathVariable String prodCode
			) {
		ResponseEntity<String> res = null;
		
		try {
			service.updateProductCodeByProductId(prodCode, prodId);
			res = new ResponseEntity<String>("Product " + prodId + " Update with code " + prodCode, HttpStatus.OK);

		} catch (ProductNotFoundException pe) {
			pe.printStackTrace();
			new ResponseEntity<String>(pe.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}

		return res;

	}

}
