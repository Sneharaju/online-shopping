package com.niit.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niit.shoppingbackend.dao.ProductDAO;
import com.niit.shoppingbackend.dto.Product;

@Controller
@RequestMapping("Json/data")

public class JsonDataController {

	@Autowired
	private ProductDAO productDAO;

	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getALLProducts() {

		return productDAO.listActiveProducts();
	}

	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getProductsbyCategory(@PathVariable int id) {

		return productDAO.listActiveProductsByCategory(id);
	}

}
