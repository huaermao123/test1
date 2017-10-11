package com.neusoft.test;

import com.neusoft.dao.impl.ProductDaoImpl;

import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;

public class TestProduct {
	
  public static void main(String[] args) {
	
	  
	  testFY();
	  
}
  //·ÖÒ³
  public static void testFY() {
	 
	  PageModel<Product>  product= new ProductDaoImpl().getproductByPage(0, 1);
	  System.out.println(product);
	  
  }
  
  
  
  
}
