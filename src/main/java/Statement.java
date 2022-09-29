

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Statement")
public class Statement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String accountno= (String) session.getAttribute("accountno");
		int account=Integer.valueOf(accountno);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql1","root","");
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM account WHERE Account_No= ?");
			stmt.setInt(1, account);
			ResultSet rs=stmt.executeQuery();
			 	while(rs.next()) {
			 		
			 		out.println("<center><h1>  Statement </h1><br> ");
			 		out.println(java.time.LocalDateTime.now()+ "<br><br>");
					out.println("<h3><br> Your Account Number is "+rs.getInt("Account_No"));
					out.println("<br><br>Your Account Type:" +rs.getString("Account_Type"));
					out.println("<br><br>Your Balance is: " +rs.getInt("Balance"));
					out.println("<br><br><h2>-- Thanks For Using Our Banking Services --</h2></cemter>");
			 	}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
