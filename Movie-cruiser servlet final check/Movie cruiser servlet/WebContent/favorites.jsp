<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Favorites</title>
<link rel="stylesheet" href="Styles/Style.css">
<script src="js/Script.js"></script>
</head>

<body onLoad="addColumn">
	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img style="width: 50px" src="Images/movie-logo.png"> <a
			href="ShowFavorites">Favorites</a> <a href="ShowMoviesListCustomer">Movies</a>
	</div>
	<h1>Favorites</h1>
	<c:if test="${message }">
		<h2>Movie Removed from favorites Successfully</h2>
	</c:if>
	<span id="span"></span>

	<table id="my-table">
		<tr>
			<th>Title</th>
			<th>Box Office</th>
			<th>Genre</th>
			<th></th>
		</tr>
		<c:forEach items="${favorites.movieList }" var="movies">
			<tr>
				<td>${movies.title }</td>
				<td class="currency">$ <fmt:formatNumber
						value="${movies.gross}" pattern="#,##,##,##,###.00" />
				</td>
				<td>${movies.genre}</td>
				<td><a href="RemoveFavorites?id=${movies.id }">Delete</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td></td>
			<td class="total">No Of Favorites</td>
			<td class="total"><fmt:formatNumber
					value="${favorites.noOfFavorites }"></fmt:formatNumber></td>
		</tr>
	</table>
	<div class="footer">
		<h6>Copyright©2019</h6>
	</div>
</body>
</html>