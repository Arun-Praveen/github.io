package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movies;

public class FavoritesDaoCollectionImpl implements FavoritesDao {

	private static HashMap<Long, Favorites> userFavorites;

	public FavoritesDaoCollectionImpl() {
		super();
		if (userFavorites == null) {
			userFavorites = new HashMap<>();
		}
	}

	@Override
	public void addFavoriteMovie(long userId, long moviesId) {
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		Movies moviesItem = moviesDao.getMovies(moviesId);
		if (userFavorites.containsKey(userId)) {
			userFavorites.get(userId).getMovieList().add(moviesItem);
		} else {
			Favorites favorites = new Favorites();
			ArrayList<Movies> moviesList = new ArrayList<>();
			moviesList.add(moviesItem);
			favorites.setMovieList(moviesList);
			userFavorites.put(userId, favorites);
		}
	}

	@Override
	public Favorites getFavoriteMovie(long userId) throws FavoriteEmptyException {

		Favorites favorites = userFavorites.get(userId);
		long total = 0;
		if (favorites == null || favorites.getMovieList().isEmpty()) {
			throw new FavoriteEmptyException();
		}
		List<Movies> moviesList = userFavorites.get(userId).getMovieList();
		for (@SuppressWarnings("unused")
		Movies movieList : moviesList) {
			total += 1;
		}

		favorites.setNoOfFavorites(total);
		return favorites;

	}

	@Override
	public void removeFavoriteMovie(long userId, long movieId) {
		List<Movies> moviesList = userFavorites.get(userId).getMovieList();
		for (int i = 0; i < moviesList.size(); i++) {
			if (moviesList.get(i).getId() == movieId) {
				moviesList.remove(i);
				return;
			}
		}
	}
}
