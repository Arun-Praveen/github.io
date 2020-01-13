package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.util.List;
import com.cognizant.moviecruiser.model.Movies;
import com.cognizant.moviecruiser.util.DateUtil;

public class MoviesDaoCollectionImplTest {

	public static void testGetMovieItemListAdmin() {
		List<Movies> moviesList = new MoviesDaoCollectionImpl().getMoviesListAdmin();
		for (Movies menu : moviesList) {
			System.out.println(menu);
		}
	}

	public static void testGetMoviesItemListCustomer() {
		System.out.println("Item list for customer");
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		List<Movies> moviesList = moviesDao.getMoviesListCustomer();
		for (Movies menuItem : moviesList) {
			System.out.println(menuItem);
		}
	}

	public static void testModifyMenuItem() {
		Movies list = new Movies(2L, "MIB", 1518812988L, true, new DateUtil().convertToDate("23/12/2017"), "Superhero",
				false);
		MoviesDao menuDao = new MoviesDaoCollectionImpl();
		menuDao.modifyMovies(list);
		System.out.println(" ***Modified List***");
		testGetMovieItemListAdmin();
		Movies modified_item = menuDao.getMovies(list.getId());
		System.out.println("Modified Item Details\n" + modified_item);
	}

	public static void main(String[] args) {
		Connection connection = ConnectionHandler.getConnection();
		System.out.println(connection);

		testGetMovieItemListAdmin();
		testGetMoviesItemListCustomer();
		testModifyMenuItem();
	}
}