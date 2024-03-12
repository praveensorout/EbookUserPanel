package cart;
import cartstore.CartStore;
import cartdata.CartDisplay;
import cartdata.CartSerializer;
import bookstore.BookStore;
import bookstore.DisplayBook;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bId = request.getParameter("bid");
		bId = bId.trim(); // if there is space after string content than we cannt parse it into integer.
		int bid = Integer.parseInt(bId);
		
		String uId = request.getParameter("uid");
		uId = uId.trim();
		int userId = Integer.parseInt(uId);
		
		DisplayBook db = new DisplayBook();
		BookStore bs = db.getBookById(bid);
		
        CartStore cs = new CartStore();
		cs.setBookId(bid);
		cs.setUserId(userId);
		cs.setFileName(bs.getFileName());
		cs.setBname(bs.getBname());
		cs.setBauthor(bs.getBauthor());
		cs.setBprice(bs.getBprice());
		cs.setBcategory(bs.getBcategory());
		
        CartDisplay cart = CartSerializer.deserializeCart();
        if (cart == null) {
            cart = new CartDisplay();
        }
        cart.addToCart(cs);
        CartSerializer.serializeCart(cart);

        response.sendRedirect(request.getContextPath() + "/cart.jsp");
    }
}
