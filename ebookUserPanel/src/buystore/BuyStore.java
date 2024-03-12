package buystore;
import java.io.*;

public class BuyStore
{
	private int bookId;
	private int userId;
	private String bname;
	private String bprice;
	private String email;
	private String contact;
	
	public void setBookId(int bookId)
	{
		this.bookId = bookId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	public void setBname(String bname)
	{
		this.bname = bname;
	}
	public void setBprice(String bprice)
	{
		this.bprice = bprice;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public void setContact(String contact)
	{
		this.contact = contact;
	}
	
	public int getBookId()
	{
		return bookId;
	}
	public int getUserId()
	{
		return userId;
	}
	public String getBname()
	{
		return bname;
	}
	public String getBprice()
	{
		return bprice;
	}
	public String getEmail()
	{
		return email;
	}
	public String getContact()
	{
		return contact;
	}
}