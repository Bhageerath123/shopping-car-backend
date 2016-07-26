package com.niit.shoppingcartbackend;







import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartbackend.dao.CategoryDAO;
import com.niit.shoppingcartbackend.model.Category;

public class CategoryTest {
  
	public static void main(String[] args){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.shoppingcartbackend");
        context.refresh();
		
		com.niit.shoppingcartbackend.dao.CategoryDAO categoryDAO = (com.niit.shoppingcartbackend.dao.CategoryDAO) context.getBean("categoryDAO");
		Category category =(Category) context.getBean("category");
		
		category.setId("CG120");
		category.setName("CGName120");
		category.setDescription("CGDESC120");
		categoryDAO.saveOrUpdate(category);
		
	
		if  (categoryDAO.get("sdsf")==null)
	{
		System.out.println("Category does not exists");
		
	}
	else
	{
		System.out.println("Category exists..the details are..");
		System.out.println();
		
	}
	
	}}
