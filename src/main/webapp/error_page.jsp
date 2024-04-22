<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sorry ! something went wrong...</title>
<!-- Css -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="css/dj.css"/> 
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
.banner_background{
clip-path: polygon(30% 0%, 70% 0%, 100% 2%, 100% 91%, 69% 100%, 33% 100%, 0 91%, 0 2%);


}

</style>
</head>
<body>
<div class = "container text-center">
<img src="images/danger.png" class="img-fluid"/>
<h3 class="display-3" >Sorry ! something went wrong...</h3>
<%= exception %>
<a  href="index.jsp" class="btn primary-bg btn-lg "> Home</a>
</div> 


</body>
</html>