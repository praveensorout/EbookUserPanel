package register;
import userdata.UserData;
import userdata.UserDisplay;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet
{
	public void doPost(HttpServletRequest req , HttpServletResponse res)throws IOException, ServletException
	{	
		PrintWriter out = res.getWriter();
		String email = req.getParameter("email");
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String phno = req.getParameter("phno");
		String city = req.getParameter("city");
		
		UserData ud = new UserData();
		ud.setEmail(email);
		ud.setName(name);
		ud.setPassword(password);
		ud.setPhno(phno);
		ud.setCity(city);
		
		UserDisplay udp = new UserDisplay();
		
		boolean valid=udp.addData(ud);
		
		if(valid)
		{
			//out.print("you have registered already!");
			req.setAttribute("msg","you have registered already!");
			req.getRequestDispatcher("registration.jsp").include(req,res);
		}
		else
		{
			res.sendRedirect("index.jsp");
		}
		
	}
}