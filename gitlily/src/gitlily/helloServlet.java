package gitlily;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//helloµÄservlet
public class helloServlet extends HttpServlet {

	private String message;
	
	@Override
	public void init() throws ServletException {
		message = "hello world!";
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		PrintWriter write = resp.getWriter();
		write.println("<h1>" + message + "</h1>");
	}


}
