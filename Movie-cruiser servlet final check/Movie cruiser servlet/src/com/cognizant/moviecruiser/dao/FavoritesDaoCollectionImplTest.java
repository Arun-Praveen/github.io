package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movies;

public class FavoritesDaoCollectionImplTest {

	public static void testAddFavoriteMovie() throws FavoriteEmptyException {
		FavoritesDao favoritesDao = new FavoritesDaoCollectionImpl();
		long totalGross = 0L;
		favoritesDao.addFavoriteMovie(1, 2L);
		favoritesDao.addFavoriteMovie(1, 5L);
		@SuppressWarnings("unchecked")
		List<Movies> moviesListCustomer = (List<Movies>) favoritesDao.getFavoriteMovie(1);
		System.out.println("user added Favorites list\n");
		for (Movies movies : moviesListCustomer) {
			System.out.println(movies);
			totalGross += movies.getGross();
		}
		System.out.println("\nno of Favorites :" + moviesListCustomer.size());
		System.out.println("total Gross :" + totalGross);

	}

	public static void testRemoveFavorites() {
		FavoritesDao favoritesDao = new FavoritesDaoCollectionImpl();
		long totalGross = 0L;
		System.out.println("\nAfter Removing");
		try {
			// favoritesDao.removeFavoriteMovie(1, 2L);
			favoritesDao.removeFavoriteMovie(1, 5L);
			@SuppressWarnings("unchecked")
			List<Movies> moviesListCustomer = (List<Movies>) favoritesDao.getFavoriteMovie(1);
			for (Movies moviesItem : moviesListCustomer) {
				System.out.println(moviesItem);
				totalGross += moviesItem.getGross();
			}
			System.out.println("\nno of Favorites :" + moviesListCustomer.size());
			System.out.println("total Gross :" + totalGross);
		} catch (FavoriteEmptyException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) throws FavoriteEmptyException {
		testAddFavoriteMovie();
		testRemoveFavorites();
	}

}
