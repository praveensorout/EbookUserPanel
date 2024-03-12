package bookstore;
import java.io.Serializable;

public class BookStore implements Serializable
{
	private int bookId;
	private String email;
	private String bname;
	private String bauthor;
	private String bprice;
	private String bcategory;
	private String fileName;
	
	public void setBookId(int bookId)
	{
		this.bookId = bookId;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public void setBname(String bname)
	{
		this.bname = bname;
	}
	public void setBauthor(String bauthor)
	{
		this.bauthor = bauthor;
	}
	public void setBprice(String bprice)
	{
		this.bprice = bprice;
	}
	public void setBcategory(String bcategory)
	{
		this.bcategory = bcategory;
	}
	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}
	
	public int getBookId()
	{
		return bookId;
	}
	public String getEmail()
	{
		return email;
	}
	public String getBname()
	{
		return bname;
	}
	public String getBauthor()
	{
		return bauthor;
	}
	public String getBprice()
	{
		return bprice;
	}
	public String getBcategory()
	{
		return bcategory;
	}
	public String getFileName()
	{
		return fileName;
	}
	
}