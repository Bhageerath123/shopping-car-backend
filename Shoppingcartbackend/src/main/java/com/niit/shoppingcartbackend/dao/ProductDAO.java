package com.niit.shoppingcartbackend.dao;





import java.util.List;

import com.niit.shoppingcartbackend.model.Product;;

public interface ProductDAO {

	public List<Product> list();
	public Product get(String id);
	public void saveorUpdate(Product product);
	public void delete(String id);
	
}
