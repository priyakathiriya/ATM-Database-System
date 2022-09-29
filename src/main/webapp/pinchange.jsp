<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pin Change</title>
</head>
<style>
body{
   background-image: url('https://images.pexels.com/photos/1292115/pexels-photo-1292115.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1');
}
</style>
<body>
<div align="center">
<form action="Pinchange" method="get">
<% String accountno= (String) session.getAttribute("accountno"); %>
Enter old PIN:<input type="number" name="oldpin"><br><br>
Enter New PIN:<input type="number" name="newpin"><br><br>
Confirm PIN:<input type="number" ><br><br>
<input type="submit" value="Submit">
</form>
</div>
</body>
</html>