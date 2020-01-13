package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import com.cognizant.moviecruiser.model.Movies;

import com.cognizant.moviecruiser.util.*;

public class MoviesDaoCollectionImpl implements MoviesDao {

	private static List<Movies> moviesList;

	public MoviesDaoCollectionImpl() {
		super();
		if (moviesList == null) {
			moviesList = new ArrayList<Movies>();
			Movies itemOne = new Movies(1L, "Avatar", 2787965087L, true, new DateUtil().convertToDate("15/03/2019"),
					"Seience Fiction", true);
			Movies itemTwo = new Movies(2L, "The Avengers", 1518812988L, true,
					new DateUtil().convertToDate("23/12/2020"), "Superhero", false);
			Movies itemThree = new Movies(3L, "Titanic", 2187463944L, true, new DateUtil().convertToDate("12/12/2020"),
					"Romance", false);
			Movies itemFour = new Movies(4L, "Jurassic World", 1671713208L, false,
					new DateUtil().convertToDate("12/12/2020"), "Seience Fiction", true);
			Movies itemFive = new Movies(5L, "Avengers: End Game", 2750760348L, true,
					new DateUtil().convertToDate("02/12/2020"), "Superhero", true);
			moviesList.add(itemOne);
			moviesList.add(itemTwo);
			moviesList.add(itemThree);
			moviesList.add(itemFour);
			moviesList.add(itemFive);

		}
	}

	@Override
	public List<Movies> getMoviesListAdmin() {

		return moviesList;
	}

	@Override
	public List<Movies> getMoviesListCustomer() {
		ArrayList<Movies> filteredMoviesItem = new ArrayList<Movies>();
		for (Movies moviesItem : moviesList) {
			if (moviesItem.getDateOfLaunch().after(new Date())) {
				if (moviesItem.isActive()) {
					filteredMoviesItem.add(moviesItem);
				}
			}
		}
		return filteredMoviesItem;
	}

	@Override
	public void modifyMovies(Movies moviesItem) {
		for (int i = 0; i < moviesList.size(); i++) {
			if (moviesList.get(i).getId() == moviesItem.getId()) {
				moviesList.set(i, moviesItem);
			}
		}
	}

	@Override
	public Movies getMovies(long moviesId) {
		for (Movies moviesItem : moviesList) {
			if (moviesItem.getId() == moviesId) {
				return moviesItem;
			}
		}
		return null;
	}
}
