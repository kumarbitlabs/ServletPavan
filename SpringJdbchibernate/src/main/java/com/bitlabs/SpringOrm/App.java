package com.bitlabs.SpringOrm;

import java.util.List;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.bitlabs.dao.Student;
import com.bitlabs.dao.StudentDaoImpl;
import com.bitlabs.dao.StudentDaoInterface;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "-----------------" );
       ApplicationContext context = new ClassPathXmlApplicationContext("com/bitlabs/SpringOrm/config.xml");
		/*
		 * HibernateTemplate tem=context.getBean("template",HibernateTemplate.class);
		 * System.out.println(tem);
		 */
       StudentDaoInterface dao= context.getBean("stDao",StudentDaoInterface.class);
		
		/* inserting a record */
		  Student st= new Student(); 
		  //st.setId(2); 
		  st.setName("Gowtham");
		  st.setAddress("vijayawada");
		  
		  dao.saveStudent(st);
		  System.out.println(" record inserted successfully");
		 
      
       
       
		  
		/*
		 * updating record- don't change id, but update what ever you want to update
		 * Student st= new Student();
		 *  st.setId(2);
		 *   st.setName("sunitha allada");
		 * st.setAddress("poranki vja");
		 * 
		 * dao.UpdateStudent(st);
		 * System.out.println(" record updated successfully");
		 */
		 
		/*
		 * getting a record
		 * Student st= dao.getStudent(2); 
		 * System.out.println(st);
		 */
       
		/*
		 * dao.deleteStudent(1); 
		 * System.out.println("record deleted successfully");
		 */
       List<Student> list=dao.getAllStudents();
       for(Student st1:list)
       {
    	   System.out.println(st1);
       }
       
       
    }
 }