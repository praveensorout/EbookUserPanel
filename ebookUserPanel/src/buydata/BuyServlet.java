package buydata;
import bookstore.BookStore;
import bookstore.DisplayBook;
import buystore.BuyStore;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/buy")
public class BuyServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException, ServletException
	{
		PrintWriter out = res.getWriter();
		String bId = req.getParameter("bid");
		bId = bId.trim(); 
		int bid = Integer.parseInt(bId);
		
		String uId = req.getParameter("uid");
		uId = uId.trim();
		int userId = Integer.parseInt(uId);
		String contact = req.getParameter("contact");
		String email = req.getParameter("email");
		
		DisplayBook db = new DisplayBook();
		BookStore bs = db.getBookById(bid);
		
        BuyStore buy = new BuyStore();
		buy.setBookId(bid);
		buy.setUserId(userId);
		buy.setBname(bs.getBname());
		buy.setBprice(bs.getBprice());
		buy.setEmail(email);
		buy.setContact(contact);
		
		DisplayBuy dbuy = new DisplayBuy();
		
		boolean valid=dbuy.addBuy(buy);
		
		if(valid)
		{
			out.print("book exists already!");
		}
		else
		{
			res.sendRedirect("index.jsp");
		}
	}
}