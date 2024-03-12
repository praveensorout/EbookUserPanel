package login;
import userdata.UserData;
import userdata.UserDisplay;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		UserDisplay udp = new UserDisplay();
		
		HttpSession session = req.getSession();
		
		PrintWriter out = res.getWriter();
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		UserData ud = udp.login(email, password);
		if(ud!=null)
		{
			session.setAttribute("userobj",ud);
			res.sendRedirect("index.jsp");
		}
		else{
			out.print("user invalid! first register. ");
		}
		
	}
}