package com.niit.shoppingcartbackend.dao;


import java.util.List;




import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcartbackend.model.Category;

@Repository("categoryDAO")
public class CategoryDAOimpl implements CategoryDAO {

  @Autowired
  private SessionFactory sessionFactory;
  
  public CategoryDAOimpl(SessionFactory sessionFactory){
	  this.sessionFactory = sessionFactory;
  }

  @Transactional
  public void saveOrUpdate(Category category){
	  sessionFactory.getCurrentSession().saveOrUpdate(category);
	  
  }
  @Transactional
  public void delete(String id){
	 Category category = new Category();
	 category.setId(id);
	 sessionFactory.getCurrentSession().delete(category);
	 
  }
  
  @Transactional
  public Category get(String id){
	  String hql = "from Category where id=" + " ' "+ id +" ' ";
	  @SuppressWarnings("rawtypes")
	Query query= (Query) sessionFactory.getCurrentSession().createQuery(hql);
	  @SuppressWarnings("unchecked")
	List<Category> listCategory = (List<Category>)  query.getResultList();
	  if (listCategory !=null && !listCategory.isEmpty()){
		  return listCategory.get(0);
	  
	  }
	  return null;
	  
  }
  @Transactional
  public List<Category> list(){
	  @SuppressWarnings("unchecked")
   	  List<Category> listCategory =(List<Category>)
   			      
   	  
   	               sessionFactory.getCurrentSession()
   	               .createCriteria(Category.class)
   	               
                   .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	         return listCategory;
	         
	  
  }



}

