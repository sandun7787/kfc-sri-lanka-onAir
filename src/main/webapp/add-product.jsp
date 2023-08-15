<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>KFC Sri Lanka onAir</title>
		
		<!-- Latest compiled and minified CSS -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
		<!-- Latest compiled JavaScript -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>		
	</head>
	
	<body>		
		<div class="container">
			<ul class="nav nav-tabs">
			  <li class="nav-item">
			    <a class="nav-link active" aria-current="page" href="#">Add Product</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" href="#">Search & Update the Product</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" href="#">View All & Delete Specific</a>
			  </li>
			</ul>
			
			<br/>
			<h2>Register Product</h2>
			<p>${feebackMessage}</p>
			<br/>
			<form action="productmanager" method="post">
				<label for="productName">Product Name:</label>
				<input class="form-control" type="text" name="name" id="productName"/>
				<br/>
			    <label for="price">Price [LKR]:</label>
			    <input class="form-control" type="number" id="price" name="price">
			    <br/>
			    <input type="hidden" name="actiontype" value="add"/>
			    <button class="btn btn-primary" type="submit">Add the Product</button>
			</form>
			
		</div>
	</body>
</html>