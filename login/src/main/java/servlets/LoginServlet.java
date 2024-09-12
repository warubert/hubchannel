package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Sample servlet class for login related methods
 */
public class LoginServlet extends HttpServlet {
	private static final String USERNAME = "admin";
    private static final String PASSWORD = "senha123";

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("link.html").include(request, response);

		String userid = request.getParameter("userid");
		String password = request.getParameter("password");

		if (userid.equals(USERNAME) && password.equals(PASSWORD)) {
			out.print("Logou! Bem Vindo, " + userid);
			HttpSession session = request.getSession();
			session.setAttribute("name", userid);
		} else {
			out.print("Erro: Nome de usuario ou senha invalidos!");
			request.getRequestDispatcher("login.html").include(request,
					response);
		}
		out.close();
	}

}
