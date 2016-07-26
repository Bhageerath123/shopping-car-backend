package com.niit.shoppingcartbackend.dao;



	import java.util.List;

	import javax.persistence.Query;

	import org.hibernate.Criteria;
	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	import org.springframework.transaction.annotation.Transactional;

	import com.niit.shoppingcartbackend.model.Suppliername;;
	@Repository("suppliernameDAO")
	public class SuppliernameDAOimpl implements SuppliernameDAO {
		
		

		  @Autowired
		  private SessionFactory sessionFactory;
		  
		  public SuppliernameDAOimpl (SessionFactory sessionFactory){
			  this.sessionFactory = sessionFactory;
		  }

		  @Transactional
		  public void saveorUpdate(Suppliername suppliername){
			  sessionFactory.getCurrentSession().saveOrUpdate(suppliername);
			  
		  }
		  @Transactional
		  public void delete(String id){
			 Suppliername suppliername = new Suppliername();
			 suppliername.setId(id);
			 sessionFactory.getCurrentSession().delete(suppliername);
			 
		  }
		  
		  @Transactional
		  public Suppliername get(String id){
			  String hql = "from Suppliername where id=" + " ' "+ id +" ' ";
			  Query query= (Query) sessionFactory.getCurrentSession().createQuery(hql);
			  List<Suppliername> listSuppliername = (List<Suppliername>)  query.getResultList();
			  if (listSuppliername !=null && !listSuppliername.isEmpty()){
				  return listSuppliername.get(0);
			  
			  }
			  return null;
			  
		  }
		  @Transactional
		  public List<Suppliername> list(){
			  @SuppressWarnings("unchecked")
		   	  List<Suppliername> listSuppliername =(List<Suppliername>)
		   			      
		   	  
		   	               sessionFactory.getCurrentSession()
		   	               .createCriteria(Suppliername.class)
		   	               
		                   .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			         return listSuppliername;
			         
			  
		  }



		}


