import java.io.IOException;
import javax.servelet.RequestDispacher;
import javax.servelet.ServletException;
import javax.servelet.http.HttpServlet;
import javax.servelet.http.HttpServletRequest;
import javax.servelet.http.HttpServletResponse;

public class Login extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest, HttpServletResponse response)
        throws ServletException, IOException {
            RequestDispacher rd = request.getRequestDispatcher("hello.jsp");
            rd.forward(request, response);
        }    
}
