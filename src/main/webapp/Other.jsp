<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type = "text/javascript">  
            function fun() {    
               confirm("confirm you want to delete");  
            }  
      </script>  
</head>
<style>
body{
   background-image: url('https://images.pexels.com/photos/1292115/pexels-photo-1292115.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1');
}
</style>
<body>
<div align="center">
<% String accountno= (String) session.getAttribute("accountno"); %>
<form action="Delete" method="get">
<h2>If you want to delete your account,
please enter below submit box:</h2>
<input type="submit" value="Submit" onclick="fun()"><br><br><br>
</form>
<form>
Otherwise search for your problem<br><br>
<input type="text" name="text" class="search" placeholder="Search here!">
 <input type="submit" name="submit" class="submit" value="Search">
</form>
</div>
</body>
</html>