<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Favorites Empty</title>
<link rel="stylesheet" href="Styles/Style.css">
<script src="js/Script.js"></script>
</head>

<body>
	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img style="width: 50px" src="Images/movie-logo.png"> <a
			href="ShowFavorites">Favorites</a> <a href="ShowMoviesListCustomer">Movies</a>

	</div>
	<h1>Favorites</h1>
	<h4 id="align">
		No items in Favorites. Use 'Add to Favorite' option in<a
			href="ShowMoviesListCustomer"> Movie List.</a>
	</h4>
	<div class="footer">
		<h6>Copyright©2019</h6>
	</div>
</body>
</html>