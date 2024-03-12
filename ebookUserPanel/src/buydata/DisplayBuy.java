package buydata;
import java.sql.*;
import java.util.*;
import buystore.BuyStore;

public class DisplayBuy
{
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	boolean valid = false;
	
	connection.DBConnect cn = new connection.DBConnect();
	
	public boolean addBuy(BuyStore buy)
	{
		con = cn.getConnection();
		try{
			ps = con.prepareStatement("select bookId and userId from buy_book where bookId=? and userId=?");
			ps.setInt(1,buy.getBookId());
			ps.setInt(2,buy.getUserId());
			rs = ps.executeQuery();
			while(rs.next())
			{
				if(buy.getBookId() == (rs.getInt("bookId")) && buy.getUserId()==(rs.getInt("userId")))
				{
					valid = true;
				}
			}
			if(!valid)
			{
				ps = con.prepareStatement("insert into buy_book(bookId,userId,bookname,price,email,contact) values(?,?,?,?,?,?)");
				ps.setInt(1,buy.getBookId());
				ps.setInt(2,buy.getUserId());
				ps.setString(3,buy.getBname());
				ps.setString(4,buy.getBprice());
				ps.setString(5,buy.getEmail());
				ps.setString(6,buy.getContact());
				ps.executeUpdate();
			}
		}
		catch(SQLException e){}
		return valid;
	}
	
}