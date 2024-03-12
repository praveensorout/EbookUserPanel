package userdata;

import java.sql.*;
import java.util.*;

public class UserDisplay
{
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	boolean valid = false;
	connection.DBConnect cn = new connection.DBConnect();
	
	public boolean addData(UserData ud)
	{
		con = cn.getConnection();
		try
		{
				ps = con.prepareStatement("select email from user_details where email=?");
				ps.setString(1,ud.getEmail());
				rs = ps.executeQuery();
				while(rs.next())
				{
					if(ud.getEmail().equals(rs.getString("email")))
					{
						valid = true;
					}
				}
			if(!valid)
			{
				ps = con.prepareStatement("insert into user_details(email,name,password,contact,city) values(?,?,?,?,?)");
				ps.setString(1,ud.getEmail());
				ps.setString(2,ud.getName());
				ps.setString(3,ud.getPassword());
				ps.setString(4,ud.getPhno());
				ps.setString(5,ud.getCity());
				ps.executeUpdate();
			}
		}
		catch(SQLException e){}
		return valid;
	}
	
	public UserData login(String email, String password)
	{
		con = cn.getConnection();
		UserData ud = null;
		try{
			ps = con.prepareStatement("select * from user_details where email=? and password=?");
			ps.setString(1,email);
			ps.setString(2,password);
			rs = ps.executeQuery();
			while(rs.next())
			{
				ud = new UserData();
				ud.setUserId(rs.getInt(1));
				ud.setEmail(rs.getString(2));
				ud.setName(rs.getString(3));
				ud.setPassword(rs.getString(4));
				ud.setPhno(rs.getString(5));
				ud.setCity(rs.getString(6));
			}
		}
		catch(SQLException e){}
		return ud;
	}
	
	
		
}