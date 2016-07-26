package com.niit.shoppingcartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartbackend.dao.SuppliernameDAO;

import com.niit.shoppingcartbackend.model.Suppliername;

public class SuppliernameTest {
	public static void main(String[] args){
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.shoppingcartbackend");
		context.refresh();
		
		SuppliernameDAO suppliernameDAO = (SuppliernameDAO) context.getBean("suppliernameDAO");
		Suppliername suppliername =(Suppliername) context.getBean("suppliername");
		
		suppliername.setId("SUP121");
		suppliername.setName("SUPName121");
		suppliername.setAddress("hyderabad");
		suppliernameDAO.saveorUpdate(suppliername);
		
		if  (suppliernameDAO.get("sdsf")==null)
		{
			System.out.println("Suppliername does not exists");
			
		}
		else
		{
			System.out.println("Suppliername exists..the details are..");
			System.out.println();
			
		}
	}
}
