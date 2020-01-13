package com.cognizant.moviecruiser.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.cognizant.moviecruiser.model.Movies;

public class MoviesDaoSqlImplTest {

	public static void testGetMovieListAdmin() {
		MoviesDao moviesDao = new MoviesDaoSqlImpl();
		List<Movies> moviesList = moviesDao.getMoviesListAdmin();
		for (Movies movies : moviesList) {
			System.out.println(movies);
		}
	}

	public static void testGetMovieListCustomer() {
		MoviesDao moviesDao = new MoviesDaoSqlImpl();
		List<Movies> moviesList = moviesDao.getMoviesListCustomer();
		for (Movies movies : moviesList) {
			System.out.println(movies);
		}
	}

	public static void testModifyMovies() throws IOException, ParseException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Enter the Id to update");
		long userId = Long.parseLong(bf.readLine());
		System.out.println("Enter the movie name to update");
		String name = bf.readLine();
		System.out.println("Enter gross to update");
		long price = Long.parseLong(bf.readLine());
		System.out.println("Enter active status to update");
		boolean active = Boolean.parseBoolean(bf.readLine());
		System.out.println("Enter Date to update");
		String date = bf.readLine();
		Date dateOfLaunch = df.parse(date);
		System.out.println("Enter Genre to update");
		String category = bf.readLine();
		System.out.println("Enter Teaser status to update");
		boolean freeDelivery = Boolean.parseBoolean(bf.readLine());
		Movies movies = new Movies(userId, name, price, active, dateOfLaunch, category, freeDelivery);
		new MoviesDaoSqlImpl().modifyMovies(movies);
		System.out.println("Success");
	}

	public static void testGetMovies() throws NumberFormatException, IOException {
		System.out.println("Enter the id");
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		long moviesId = Long.parseLong(bf.readLine());
		Movies movies = new MoviesDaoSqlImpl().getMovies(moviesId);
		System.out.println(movies);
	}

	public static void main(String[] args) throws IOException, ParseException {
		 testGetMovieListAdmin();
		 testGetMovieListCustomer();
		 testModifyMovies();
		testGetMovies();
	}
}