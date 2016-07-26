package com.niit.shoppingcartbackend;


	import org.springframework.context.annotation.AnnotationConfigApplicationContext;

	import com.niit.shoppingcartbackend.dao.ProductDAO;
	import com.niit.shoppingcartbackend.model.Product;;

	public class ProductTest {
	  
		public static void main(String[] args){
			AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
			
			context.scan("com.niit.shoppingcartbackend");
			context.refresh();
			
			ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");
			Product product =(Product) context.getBean("product");
			
			product.setId("PRO122");
			product.setName("PROName122");
			product.setDescription("PRODESC122");
			product.setPrice(20000);
			productDAO.saveorUpdate(product);
			
			if  (productDAO.get("sdsf")==null)
			{
				System.out.println("Product does not exists");
				
			}
			else
			{
				System.out.println("Product exists..the details are..");
				System.out.println();
				
			}
		}
		
		}


