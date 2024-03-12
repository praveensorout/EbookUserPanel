package bookstore;
import java.sql.*;
import java.util.*;

public class DisplayBook
{
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	connection.DBConnect cn = new connection.DBConnect();
	
	// Display C/C++ books on index page
	
	public Map<Integer,BookStore> displayCBook()
	{
		con = cn.getConnection();
		HashMap<Integer,BookStore> map = new HashMap<Integer,BookStore>();
		try{
			ps = con.prepareStatement("select * from book_details where book_category=? order by book_id DESC");
			ps.setString(1,"C/C++");
			rs = ps.executeQuery();
			int i = 1;
			while(rs.next() && i<=4)
			{
				BookStore bs = new BookStore();
				bs.setBookId(rs.getInt("book_id"));
				bs.setBname(rs.getString("bookname"));
				bs.setBauthor(rs.getString("author"));
				bs.setBprice(rs.getString("price"));
				bs.setBcategory(rs.getString("book_category"));
				bs.setFileName(rs.getString("image"));
				
				map.put(rs.getInt("book_id"),bs);
				i++;
			}
		}
		catch(SQLException e){}
		return map;
	}
	
	// Display Java books on index page
	
	public Map<Integer,BookStore> displayJavaBook()
	{
		con = cn.getConnection();
		HashMap<Integer,BookStore> map = new HashMap<Integer,BookStore>();
		try
		{
			ps = con.prepareStatement("select * from book_details where book_category=? order by book_id DESC");
			ps.setString(1,"java");
			rs = ps.executeQuery();
			int i=1;
			while(rs.next() && i<=4)
			{
				BookStore bs = new BookStore();
				bs.setBookId(rs.getInt("book_id"));
				bs.setBname(rs.getString("bookname"));
				bs.setBauthor(rs.getString("author"));
				bs.setBprice(rs.getString("price"));
				bs.setBcategory(rs.getString("book_category"));
				bs.setFileName(rs.getString("image"));
				
				map.put(rs.getInt("book_id"),bs);
				i++;
			}
			
		}
		catch(SQLException e){}
		return map;
	}
	
	// Display old books on index jsp page
	
	public Map<Integer,BookStore> displayPythonBook()
	{
		con = cn.getConnection();
		HashMap<Integer,BookStore> map = new HashMap<Integer,BookStore>();
		try
		{
			ps = con.prepareStatement("select * from book_details where book_category=? order by book_id DESC");
			ps.setString(1,"python");
			rs = ps.executeQuery();
			int i=1;
			while(rs.next()&& i<=4)
			{
				BookStore bs = new BookStore();
				bs.setBookId(rs.getInt("book_id"));
				bs.setBname(rs.getString("bookname"));
				bs.setBauthor(rs.getString("author"));
				bs.setBprice(rs.getString("price"));
				bs.setBcategory(rs.getString("book_category"));
				bs.setFileName(rs.getString("image"));
				
				map.put(rs.getInt("book_id"),bs);
				i++;
			}
			
		}
		catch(SQLException e){}
		return map;
	}
	
	// Display All Recent Books

		public Map<Integer,BookStore> AllCBook()
		{
			con = cn.getConnection();
			HashMap<Integer,BookStore> map = new HashMap<Integer,BookStore>();
			try{
				ps = con.prepareStatement("select * from book_details where book_category=?");
				ps.setString(1,"C/C++");
				rs = ps.executeQuery();
				while(rs.next())
				{
					BookStore bs = new BookStore();
				bs.setBookId(rs.getInt("book_id"));
				bs.setBname(rs.getString("bookname"));
				bs.setBauthor(rs.getString("author"));
				bs.setBprice(rs.getString("price"));
				bs.setBcategory(rs.getString("book_category"));
				bs.setFileName(rs.getString("image"));
				
				map.put(rs.getInt("book_id"),bs);
				}
			}
			catch(SQLException e){}
			return map;
		}
		
	// Display All New Books
	
			public Map<Integer,BookStore> AllJavaBook()
			{
				con = cn.getConnection();
				HashMap<Integer,BookStore> map = new HashMap<Integer,BookStore>();
				try
				{
					ps = con.prepareStatement("select * from book_details where book_category=?");
					ps.setString(1,"java");
					rs = ps.executeQuery();
					while(rs.next())
					{
						BookStore bs = new BookStore();
				bs.setBookId(rs.getInt("book_id"));
				bs.setBname(rs.getString("bookname"));
				bs.setBauthor(rs.getString("author"));
				bs.setBprice(rs.getString("price"));
				bs.setBcategory(rs.getString("book_category"));
				bs.setFileName(rs.getString("image"));
				
				map.put(rs.getInt("book_id"),bs);
					}
					
				}
				catch(SQLException e){}
				return map;
			}
	
	// Display All Old Books
		
		public Map<Integer,BookStore> AllPythonBook()
		{
			con = cn.getConnection();
			HashMap<Integer,BookStore> map = new HashMap<Integer,BookStore>();
			try
			{
				ps = con.prepareStatement("select * from book_details where book_category=?");
				ps.setString(1,"python");
				rs = ps.executeQuery();
				while(rs.next())
				{
					BookStore bs = new BookStore();
				bs.setBookId(rs.getInt("book_id"));
				bs.setBname(rs.getString("bookname"));
				bs.setBauthor(rs.getString("author"));
				bs.setBprice(rs.getString("price"));
				bs.setBcategory(rs.getString("book_category"));
				bs.setFileName(rs.getString("image"));
				
				map.put(rs.getInt("book_id"),bs);
				}
				
			}
			catch(SQLException e){}
			return map;
		}
		
	// Get book by Id
	
		public BookStore getBookById(int id)
		{
			con = cn.getConnection();
			BookStore bs =null;
			try{
					ps = con.prepareStatement("select * from book_details where book_id=?");
					ps.setInt(1,id);
					
					rs = ps.executeQuery();
					while(rs.next())
					{
						bs = new BookStore();
						bs.setEmail(rs.getString(1));
						bs.setBname(rs.getString(2));
						bs.setBauthor(rs.getString(3));
						bs.setBprice(rs.getString(4));
						bs.setBcategory(rs.getString(5));
						bs.setFileName(rs.getString(6));
						bs.setBookId(rs.getInt(7));
						
					}
			}
			catch(SQLException e){System.out.println(e);}
			return bs;
		}
	   
}