<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main Page</title>
<style type="text/css">
body {
  background-image: url('https://images.pexels.com/photos/1292115/pexels-photo-1292115.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1');
  background-color: lightblue;
}
input[type=button], input[type=submit], input[type=reset] {
  background-color: #04AA6D;
  border: none;
  color: white;
  padding: 16px 32px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
}
</style>
</head>
<body>
<div align="center">
<h1>WELCOME IN ATM SERVICE</h1>
<% 
String accountno=request.getParameter("accountno");
session.setAttribute("accountno", accountno);
%>

<form action="Statement" method="get">
<input type="submit" value="Mini Statement" name="statement"><br><br>
</form>
<form action="Balance" method="get">
<input type="submit" value="Balance" ><br><br>
</form>
<form action="withdraw.jsp" method="get">
<input type="submit" value="Cash Withdrawal"><br><br>
</form>
<form action="deposit.jsp">
<input type="submit" value="Deposit Cash" name="deposit"><br><br>
</form>
<form action="pinchange.jsp">
<input type="submit" value="PIN Change" name="pinchange"><br><br>
</form>
<form action="Other.jsp">
<input type="submit" value="Others" name="other"><br><br>
</form>
</div>
</body>
</html>