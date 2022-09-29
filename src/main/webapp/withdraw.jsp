<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cash Withdraw</title>
</head>
<style>
body{
   background-image: url('https://images.pexels.com/photos/1292115/pexels-photo-1292115.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1');
}
</style>
<body>
<div align="center">
<form action="Process3" method="get">
<% String accountno= (String) session.getAttribute("accountno"); %>
<h1>Enter Amount that you want to withdraw:<br><br>
<input type="number" name="amount"><br><br>
<input type="submit" value="Submit"><br><br></h1>
</form>
</div>
</body>
</html>