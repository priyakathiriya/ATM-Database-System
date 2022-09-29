

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

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String accountno= (String) session.getAttribute("accountno");
		int account=Integer.valueOf(accountno);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql1","root","");
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM account WHERE Account_No= ?");
			stmt.setInt(1, account);
			stmt.execute();
			PreparedStatement stmt1 = conn.prepareStatement("DELETE FROM customer WHERE Account_No= ?");
			stmt1.setInt(1, account);
			stmt1.execute();
			 	//while(rs.next()) {
			 		out.println("<center><h1><u> your account is deleted </u></h1><hr> ");
					out.println("<br><hr><h2>-- Thanks For Using Our Banking Services --</h2></center>");
			 	//}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
