

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Process3")
public class Process3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String accountno= (String) session.getAttribute("accountno");
		int amount=Integer.parseInt(request.getParameter("amount"));
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql1","root","");
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM account WHERE Account_No=" +accountno);
			ResultSet rs=stmt.executeQuery();

			while(rs.next()) {
				int balance=rs.getInt("Balance");
				int balance1=balance-amount;
				PreparedStatement stmt1 = conn.prepareStatement("UPDATE account SET Balance=? WHERE Account_No=" +accountno);
				stmt1.setInt(1, balance1);
				stmt1.executeUpdate();
					out.println("<center><h1>  Witdrawal of Cash </h1><br> ");
			 		out.println(java.time.LocalDateTime.now()+ "<br><br>");
					out.println("You are successfully Withdraw cash...<br><br>");
					out.println("<br><br><h2>-- Thanks For Using Our Banking Services --</h2></center>");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
