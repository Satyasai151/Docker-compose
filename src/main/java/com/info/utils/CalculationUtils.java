package com.info.utils;

import com.info.entity.Product;

public class CalculationUtils {
	public static void blogic(Product product) {
		Double prodCost = product.getProdCost();
		product.setProdDis(prodCost * 12 / 100);
		product.setProdGst(prodCost * 18 / 100);

	}

}
