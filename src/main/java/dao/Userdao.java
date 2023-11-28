package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.Userdto;

public class Userdao {
EntityManagerFactory f=Persistence.createEntityManagerFactory("dev");
EntityManager m=f.createEntityManager();
public void saveUser(Userdto dto)
{
	m.getTransaction().begin();
	m.persist(dto);
	m.getTransaction().commit();;
}
public Userdto findbyemail(String  email) {
	      Query q= m.createQuery("select x from Userdto x where email=?1").setParameter(1, email);
	      List<Userdto> l=q.getResultList();
	      if(!l.isEmpty())
	      {
	    	  return l.get(0);
	      }
	      else{
	    	 return null; 
	      }
}


}
