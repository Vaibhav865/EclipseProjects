package servletDay01;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		try {
			PrintWriter pw = resp.getWriter();
			
			pw.println("<h1> Employee Details </h1>");
			pw.println("<p>Name : Vaibhav <p>");
			pw.println("<p>Emai : vaibhavpekhale865@gmail.com</p>");
			pw.println("<p>Age : 22</p>");
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
}
