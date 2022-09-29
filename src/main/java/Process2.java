

import java.io.*;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Process2")
public class Process2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int accountno=Integer.parseInt(request.getParameter("accountno"));
		int pin=Integer.parseInt(request.getParameter("pin"));
		HttpSession session=request.getSession();
        session.setAttribute("accountno", accountno);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql1","root","");
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM CUSTOMER WHERE Account_No= ? AND PIN= ?");
			stmt.setInt(1, accountno);
			stmt.setInt(2, pin);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				
					RequestDispatcher rd=request.getRequestDispatcher("mainmenu.jsp");
					rd.forward(request, response);
			}
			
			else {
				    out.println("<center><h1><b>You have entered incoorect information </b></h1></center>");
				    RequestDispatcher rd=request.getRequestDispatcher("Login.html");
				    rd.include(request, response);    
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
