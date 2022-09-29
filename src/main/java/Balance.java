

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

@WebServlet("/Balance")
public class Balance extends HttpServlet {
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
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM account WHERE Account_No= ?");
			stmt.setInt(1, account);
			ResultSet rs=stmt.executeQuery();
			 	while(rs.next()) {
			 		int avail=rs.getInt("Balance");
			 		out.println("<center><h1><u> Bank Balance Information </u></h1><hr> ");
					out.println("<h3><br> Available Balance is "+avail);
					out.println("<br><hr><h2>-- Thanks For Using Our Banking Services --</center>");
			 	}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
