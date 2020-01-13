<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movie list</title>
<link rel="stylesheet" href="Styles/Style.css">
<script src="js/Script.js"></script>
</head>

<body>
	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img style="width: 50px" src="Images/movie-logo.png"> <a
			href="ShowFavorites">Favorites</a> <a href="ShowMoviesListCustomer">Movies</a>
	</div>
	<h1>Movies</h1>
	<c:if test="${addFavoritesStatus}">
		<h2>Movie Added to favorites Successfully</h2>
	</c:if>
	<table>
		<tr>
			<th>Title</th>
			<th>Box Office</th>
			<th>Genre</th>
			<th>Has Teaser</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${movies}" var="movies">
			<tr>
				<td><c:out value="${movies.title}" /></td>
				<td><fmt:setLocale value="en_US" /> <fmt:formatNumber
						value="${movies.gross}" type="currency" /></td>
				<td><c:out value="${movies.genre}" /></td>
				<td><c:if test="${movies.teaser eq 'true'}">Yes</c:if> <c:if
						test="${movies.teaser eq 'false'}">No</c:if></td>
				<td><a href="AddToFavorites?id=${movies.id }">Add To
						Favorites</a></td>
			</tr>
		</c:forEach>
	</table>
	<div class="footer">
		<h6>Copyright©2019</h6>
	</div>
</body>
</html>