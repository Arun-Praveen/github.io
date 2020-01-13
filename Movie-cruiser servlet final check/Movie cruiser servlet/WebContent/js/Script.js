function validateForm() {
	var title = document.forms["movie"]["title"].value;
	if (title == "") {
		alert("Title is required");
		return false;
	}

	var titleLength = title.length;
	if (titleLength < 2 || titleLength > 65) {
		alert("Title should have 2 to 100 characters");
		return false;
	}

	var price = document.forms["movie"]["boxOffice"].value;
	if (isNaN(price)) {
		alert("Box Office has to be a number");
		return false;
	}
	if (price == "") {
		alert('Box office is required');
		return false;
	}

	var dateOfLaunch = document.forms["movie"]["dateOfLaunch"].value;
	if (dateOfLaunch == "") {
		alert("Date of launch is required")
		return false;
	}

	var genre = document.forms["movie"]["genre"].value;
	if (genre == "0") {
		alert("Select one genre");
	}

	if (!dateOfLaunch
			.match(/^(0[1-9]|[12][0-9]|3[01])[\- \/.](?:(0[1-9]|1[012])[\-\/.](19|20)[0-9]{2})$/)) {
		alert("Incorrect date format. Expected Format (dd/mm/yyyy)");
		return false;
	}
}
