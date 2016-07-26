package com.niit.shoppingcartbackend;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartbackend.dao.UserDAO;
import com.niit.shoppingcartbackend.model.User;;

public class UserTest {
  
	public static void main(String[] args){
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.shoppingcartbackend");
		context.refresh();
		
		UserDAO userDAO = (UserDAO) context.getBean("userDAO");
		User user =(User) context.getBean("user");
		
		user.setId("user123");
		user.setName("xxx");
		user.setPassword("xxx");
		user.setMobile(12345);
		user.setMail("xxxx");
		user.setAddress("kothapet");
		userDAO.saveorUpdate(user);
		
		if  (userDAO.get("sdsf")==null)
		{
			System.out.println("User does not exists");
			
		}
		else
		{
			System.out.println("User exists..the details are..");
			System.out.println();
			
		}
	}
	
	}




