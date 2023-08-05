package demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/demologin")
public class Login extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		int password = Integer.parseInt(req.getParameter("pwd"));
		if(email.equals("afshan@gmail.com") && password==1234) {
//			Cookie c = new Cookie("abc", "xyz");
//			resp.addCookie(c);
			
			HttpSession hs  = req.getSession();
			hs.setAttribute("abc", "xyz");
			
			RequestDispatcher rd = req.getRequestDispatcher("demoHome.jsp");
			rd.forward(req, resp);
		}else {
			PrintWriter pw = resp.getWriter();
			pw.write("<html>\r\n"
					+ "<body>\r\n"
					+ "<h4 style=\"color: red;\">EMAIL OR PASSWORD IS WRONG</h4>\r\n"
					+ "</body>\r\n"
					+ "</html>");
			
			RequestDispatcher rd = req.getRequestDispatcher("demoLogin.html");
			rd.include(req, resp);
		}
	}
}
