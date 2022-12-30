package com.bitlabs;

import java.util.*;
import java.sql.*;

public class EmpDao {
	Connection con=null;
EmpDao(){
        
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletcrud","root","root");
         }
         catch (Exception e)
        {
          // TODO Auto-generated catch block
           e.printStackTrace();
         }
        }

public  int save(Emp e){
	int status=0;
	try{
            
            
		PreparedStatement ps=con.prepareStatement("insert into emp values(?,?,?,?,?)");
            ps.setString(1,e.getName());
ps.setString(2,e.getPassword());
ps.setString(3,e.getEmail());
ps.setString(4,e.getCountry());
ps.setString(5, null);
status=ps.executeUpdate();
con.close();
}
	catch(Exception ex)
	{
		ex.printStackTrace();
		}
	return status;
	}


public  int update(Emp e){
	int status=0;
	try
	{
		//Connection con=EmpDao.getConnection();
		PreparedStatement ps=con.prepareStatement("update emp set name=?,password=?,email=?,country=? where id=?");
		//PreparedStatement ps=con.prepareStatement("update emp set name=?,password=?,email=?,country=? where id=?");
ps.setString(1,e.getName());
ps.setString(2,e.getPassword());
ps.setString(3,e.getEmail());
ps.setString(4,e.getCountry());
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
	catch
	(
			Exception e)
	{e.printStackTrace();}
	return status;
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
			   e.setId(rs.getInt(5));
			   e.setName(rs.getString(1));
			   e.setPassword(rs.getString(2));
			   e.setEmail(rs.getString(3));
			   e.setCountry(rs.getString(4));
			   }
		   con.close();
		   }catch(Exception ex){ex.printStackTrace();}
	   return e;
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
			   e.setId(rs.getInt(5));
			   e.setName(rs.getString(1));
			   e.setPassword(rs.getString(2));
			   e.setEmail(rs.getString(3));
			   e.setCountry(rs.getString(4));
			   list.add(e);
			   }
		   con.close();
		   }catch(Exception e){e.printStackTrace();}
	   return list;
	   }
}