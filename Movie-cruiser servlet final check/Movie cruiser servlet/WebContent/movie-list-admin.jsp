<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movie Cruiser</title>
<link rel="stylesheet" href="Styles/Style.css">
<script src="js/Script.js"></script>
</head>
<body>
	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img style="width: 50px" src="Images/movie-logo.png"> <a
			href="ShowMoviesListAdmin">Movies</a>
	</div>
	<h1>Movies</h1>
	<table>
		<tr>
			<th>Title</th>
			<th>Box Office</th>
			<th>Active</th>
			<th>Date of Launch</th>
			<th>Genre</th>
			<th>Has Teaser</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${movies}" var="movies">
			<tr>
				<td>${movies.title}</td>
				<td>$<fmt:formatNumber value="${movies.gross}"
						pattern="#,##,##,##,###.00" /></td>
				<td><c:choose>
						<c:when test="${movies.active}">Yes</c:when>
						<c:otherwise>No</c:otherwise>
					</c:choose></td>
				<td><fmt:formatDate type="date" pattern="dd/MM/yyyy"
						value="${movies.dateOfLaunch}" /></td>
				<td>${movies.genre}</td>
				<td><c:choose>
						<c:when test="${movies.teaser}">Yes</c:when>
						<c:otherwise>No</c:otherwise>
					</c:choose></td>
				<td><a href="ShowEditMovies?id=${movies.id}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
	<div class="footer">
		<h6>Copyright©2019</h6>

	</div>
</body>
</html>