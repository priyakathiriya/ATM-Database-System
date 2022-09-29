
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Pinchange")
public class Pinchange extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String accountno= (String) session.getAttribute("accountno");
		int newpin=Integer.parseInt(request.getParameter("newpin"));
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql1","root","");
			PreparedStatement stmt = conn.prepareStatement("UPDATE account SET PIN=? WHERE Account_No=" +accountno);
			stmt.setInt(1, newpin);
			stmt.executeUpdate();
			PreparedStatement stmt1 = conn.prepareStatement("UPDATE customer SET PIN=? WHERE Account_No=" +accountno);
			stmt1.setInt(1, newpin);
			stmt1.executeUpdate();
				
			 	out.println("<center><h1><u> Your pin number has been changed </u></h1><hr> ");
				out.println("<br><hr><h2>-- Thanks For Using Our Banking Services --</h2></center>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
