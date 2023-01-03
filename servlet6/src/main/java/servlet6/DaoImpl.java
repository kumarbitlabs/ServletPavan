package servlet6;

import java.sql.*;

public class DaoImpl {
	 Connection con=null;
		DaoImpl(String driver,String user,String upwd)
	       {
			try 
	        {
				Class.forName(driver);
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bitlabs",user,upwd);
			}
	        catch (Exception e)
	        {
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
		
		public void viewAllUsers() {
			// TODO Auto-generated method stub
			try {
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select * from userinfo");
				while(rs.next()){
					System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}

   
		
