package com.bitlabs.hibtut1;




import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        
        Configuration cfg= new Configuration();
        cfg.configure();
        cfg.addAnnotatedClass(Emp.class);
        
        SessionFactory factory= cfg.buildSessionFactory();
        
        //System.out.println(factory);
        
        /*SessionFactory factory= new Configuration()
                                       .configure()
                                       .addAnnotatedClass(Emp.class)
                                       .buildSessionFactory();*/
        
        Session session = factory.openSession();
        
        try {
        	//create an object of Entity class
        	//Emp e1=new Emp();
        	//e1.setName("kumar");
        	//e1.setAddress("poranki");
        	//e1.setContact("9247581589");
        	//e1.setEmail("kumarap.1980@gmail.com");
        	
        	//Emp e2=new Emp(2,"kumar","gudivada","8999999988","sunitha@gmailcom");
        	
        	Emp e= new Emp();
        	
        	//start transaction        	
        	session.beginTransaction();
        	
        	
        	//perform operation
        	//for inserting  
        	//session.save(e2);  
        	// for retrieving one record 
        	//e = session.get(Emp.class, 1);
        	/*
        	 * for fetching all data from table
        	List<Emp> list = session.createQuery("from Emp",Emp.class).list();
        	list.forEach(employee -> {
        	    System.out.println(employee);
        	    
        	});   
        	 */  
        	/*
        	 * second way of writing query for fetching all data from table
        	 
        	String hql = "FROM Emp";
             Query query = session.createQuery(hql);

             //Execute the query and store the results in a list
              List<Emp> list = query.list();
        	list.forEach(employee -> {
        	    System.out.println(employee);
        	    
        	});   
        	 
        	*/
        	/*updating -fetch one record and use setter methods
        	e = session.get(Emp.class, 0);
        	e.setEmail("g@rediffmail.com");
        	*/
        	//Deleting a Record with emp id 0
        	e = session.get(Emp.class, 1);
  		  
  		  session.delete(e);
        	
        	//commit the transaction
			session.getTransaction().commit();
			
			
		} finally {
			session.close();
			factory.close();
		}
        
       
        
        
    }
}
