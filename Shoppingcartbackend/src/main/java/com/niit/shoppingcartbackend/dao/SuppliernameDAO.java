package com.niit.shoppingcartbackend.dao;



	import java.util.List;

	import com.niit.shoppingcartbackend.model.Suppliername;;

	public interface SuppliernameDAO {
		public List<Suppliername> list();
		public Suppliername get(String id);
		public void saveorUpdate(Suppliername suppliername);
		public void delete(String id);
		
	}


