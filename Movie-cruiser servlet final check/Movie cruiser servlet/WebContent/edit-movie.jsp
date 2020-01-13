<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Movie</title>
<link rel="stylesheet" href="Styles/Style.css">
<script src="js/Script.js"></script>
</head>

<body>
	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img style="width: 50px" src="Images/movie-logo.png"> <a
			href="movie-list-admin.html">Movies</a>

	</div>
	<h1>Edit Movie</h1>
	<div class="body-content-color">

		<form action="EditMovies" onsubmit="return validateForm()"
			name="movie" method="post">
			<div class="form-field-spacing">
				<label for="name">Title</label>
				<div>
					<input type="text" value="${movies.title }" class="name-box"
						name="title" id="name">
				</div>
			</div>
			<div>
				<input type="hidden" name="id" value="${movies.id }">
			</div>
			<div>
				<div class="form-field-spacing">
					<label for="gross">Gross ($)</label>
					<div>
						<input type="text" value="${movies.gross }" class="text-box"
							name="boxOffice">
					</div>
				</div>


				<div class="form-field-spacing">
					<label for="instock">Active</label>
					<div>
						<input class="radio" type="radio" name="active" value="Yes"
							<c:if test="${movies.active }">checked </c:if>>Yes <input
							class="radio" type="radio" name="active" value="No"
							<c:if test="${!movies.active }">checked </c:if>>No
					</div>
				</div>



				<div class="form-field-spacing">
					<label for="dateOfLaunch">Date of Launch</label>
					<div>

						<input type="text" class="text-box" name="dateOfLaunch"
							value="<fmt:formatDate type="date" pattern="dd/MM/yyyy"
                                         value="${movies.dateOfLaunch}" />">
					</div>
				</div>


				<div class="form-field-spacing">
					<label for="genre">Genre</label>
					<div>
						<select name="genre" class="dropdown" id="genre">
							<option value="${movies.genre }">${movies.genre }</option>
							<option value="sciencefiction">Science Fiction</option>
							<option value="superhero">Superhero</option>
							<option value="Romance">Romance</option>
							<option value="comedy">Comedy</option>
							<option value="adventure">Adventure</option>
							<option value="thriller">Thriller</option>
						</select>
					</div>
				</div>
			</div>
			<div>
				<div class="form-field-spacing">
					<input type="checkbox" id="hasTeaser" name="teaser"
						<c:if test="${movies.teaser }">checked</c:if>>
					<c:if test="${!movies.teaser }"></c:if>
					<label for="hasTeaser">Has Teaser</label>
				</div>
			</div>
			<div>
				<div>
					<input type="hidden" name="id" value="${Movies.id }">
				</div>
				<input type="submit" class="success-button" value="Save">

			</div>
		</form>
	</div>

	<div class="footer">
		<h6>Copyright©2019</h6>
	</div>
</body>
</html>