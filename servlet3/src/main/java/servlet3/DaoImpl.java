package servlet3;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DaoImpl implements DaoInterface{
	Connection con=null;
	
	DaoImpl()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bitlabs","root","root");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public boolean validate(String uname,String pwd)
	{
		try {
			Statement st= con.createStatement();
			String query = "select * from userinfo";
			ResultSet rs = st.executeQuery(query);
			while(rs.next())
			{
				if(rs.getString(2).equals(uname) && rs.getString(3).equals(pwd))
					return true;
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
}
