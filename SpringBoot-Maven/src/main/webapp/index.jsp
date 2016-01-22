<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>My Pethosp</title>
	
	<!-- Libraries -->
	<script type="text/javascript" src="./js/lib/angular.js"></script>
	
	<!-- Modules -->
	<script type="text/javascript" src="./js/app.js"></script>
	<script type="text/javascript" src="./js/category/category.js"></script>
	
	<!-- Controllers -->
	<script type="text/javascript" src="./js/category/categoryCtrl.js"></script>
	
	<!-- Services -->
	<script type="text/javascript" src="./js/category/categoryService.js"></script>
	
</head>
<body ng-app="Petshop">
	<div>
		{{categoryList}}	
	</div>
</body>
</html>