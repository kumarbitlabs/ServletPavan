package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Emp;

public class EmpDao {
	private Connection con;

	public EmpDao(Connection con) {
		super();
		this.con = con;
	}
    
	
   public int addEmp(Emp e)
   {
	   int status=0;
	   try {
		   
		   String query ="insert into emp(name,address,contact,email) values(?,?,?,?)";
		   
		   
		   PreparedStatement ps = con.prepareStatement(query);
		   ps.setString(1, e.getName());
		   ps.setString(2, e.getAddress());
		   ps.setString(3, e.getContact());
		   ps.setString(4, e.getEmail()); 
		   status=ps.executeUpdate();
		   con.close();
		
	} catch (Exception e2) {
		e2.printStackTrace();
	}   
	   return status;
   }
   
   
   public List<Emp> getAllEmployees(){
	   List<Emp> list=new ArrayList<Emp>();
	   try{
		  // Connection con=EmpDao.getConnection();
		   PreparedStatement ps=con.prepareStatement("select * from emp");
		  // PreparedStatement ps=con.prepareStatement("select * from emp");
		   ResultSet rs=ps.executeQuery();
		   while(rs.next()){
			   Emp e=new Emp();
			   e.setId(rs.getInt(1));
			   e.setName(rs.getString(2));
			   e.setAddress(rs.getString(3));
			   e.setContact(rs.getString(4));
			   e.setEmail(rs.getString(5));
			   list.add(e);
			   }
		   con.close();
		   }catch(Exception e){e.printStackTrace();}
	   return list;
	   }
	
   
   
   public  Emp getEmployeeById(int id){
	   Emp e=new Emp();
	   try{
		   //Connection con=EmpDao.getConnection();
		   //PreparedStatement ps=con.prepareStatement("select * from emp where id=?");
		   PreparedStatement ps=con.prepareStatement("select * from emp where id=?");
		   ps.setInt(1,id);
		   ResultSet rs=ps.executeQuery();
		   if(rs.next()){
			   e.setId(rs.getInt(1));
			   e.setName(rs.getString(2));
			   e.setAddress(rs.getString(3));
			   e.setContact(rs.getString(4));
			   e.setEmail(rs.getString(5));
			   }
		   con.close();
		   }catch(Exception ex){ex.printStackTrace();}
	   return e;
	   }
	
   public  int update(Emp e){
		int status=0;
		try
		{
			//Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("update emp set name=?,address=?,contact=?,email=? where id=?");
			//PreparedStatement ps=con.prepareStatement("update emp set name=?,password=?,email=?,country=? where id=?");
	ps.setString(1,e.getName());
	ps.setString(2, e.getAddress());
	   ps.setString(3, e.getContact());
	   ps.setString(4, e.getEmail()); 
	   ps.setInt(5,e.getId());
	   
	   status=ps.executeUpdate();
	con.close();
	}
		catch(Exception ex)
		{
			ex.printStackTrace();
			}
		return status;
		}
	
   
   public  int delete(int id){
		int status=0;
		try{
			//Connection con=EmpDao.getConnection();
			//PreparedStatement ps=con.prepareStatement("delete from emp where id=?");
			PreparedStatement ps=con.prepareStatement("delete from emp where id = ?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
		}
		catch(Exception e)
		{e.printStackTrace();}
		return status;
		}
   
   
   public List<Emp> getEmployeeByName(String name){
	   List<Emp> list=new ArrayList<Emp>();
	   try{
		  // Connection con=EmpDao.getConnection();
		   PreparedStatement ps=con.prepareStatement("select * from emp where name=?");
		  // PreparedStatement ps=con.prepareStatement("select * from emp");
		   ps.setString(1,name);
		   ResultSet rs=ps.executeQuery();
		   while(rs.next()){
			   Emp e=new Emp();
			   e.setId(rs.getInt(1));
			   e.setName(rs.getString(2));
			   e.setAddress(rs.getString(3));
			   e.setContact(rs.getString(4));
			   e.setEmail(rs.getString(5));
			   list.add(e);
			   }
		   con.close();
		   }catch(Exception e){e.printStackTrace();}
	   return list;
	   }
	
   

}
