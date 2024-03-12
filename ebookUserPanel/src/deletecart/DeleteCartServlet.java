package deletecart;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.annotation.WebServlet;

import cartdata.CartDisplay;
import cartdata.CartSerializer;
import bookstore.BookStore;

@WebServlet("/deletecart")
public class DeleteCartServlet extends HttpServlet
{
	// when we apply the url in <a href="url"> tag it sends by get method.
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		PrintWriter out = res.getWriter();
		String bId = req.getParameter("bid");
		bId = bId.trim();
		int bookId = Integer.parseInt(bId);
		
		BookStore bs = new BookStore();
		bs.setBookId(bookId);
		
        CartDisplay cart = CartSerializer.deserializeCart();
        if (cart == null) {
            cart = new CartDisplay();
        }
        cart.removeFromCart(bookId);
        CartSerializer.serializeCart(cart);

        res.sendRedirect(req.getContextPath() + "/cart.jsp");
	}
	
}