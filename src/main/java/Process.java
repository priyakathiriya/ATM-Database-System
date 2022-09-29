

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
import javax.swing.JOptionPane;

@WebServlet("/Process")
public class Process extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String accountno=request.getParameter("accountno");
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String pin=request.getParameter("pin");
		String e=request.getParameter("email");
		String a=request.getParameter("address");
		String d=request.getParameter("dob");
		String g=request.getParameter("gender");
		

		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql1","root","");
		PreparedStatement ps=con.prepareStatement("insert into customer values(?,?,?,?,?,?,?,?)");
		ps.setString(1, accountno);
		ps.setString(2, fname);
		ps.setString(3, lname);
		ps.setString(4, pin);
		ps.setString(5, e);
		ps.setString(6, a);
		ps.setString(7, d);
		ps.setString(8, g);
		HttpSession session=request.getSession();
        session.setAttribute("accountno", accountno);
		int i=ps.executeUpdate();
		if(i>0){
		out.print("you are successfully registered....");
		JOptionPane.showMessageDialog(null,"you are successfully registered...");
		response.sendRedirect("Login.html");
		}
		}
		catch(Exception e1){
		System.out.println(e1);
		}
	}

}
