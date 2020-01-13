package com.cognizant.moviecruiser.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.cognizant.moviecruiser.model.Favorites;

public class FavoritesDaoSqlImplTest {

	public static void testAddToFavorites() throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the userId");
		long userId = Long.parseLong(bf.readLine());
		System.out.println("Enter the Movie Id");
		long movieId = Long.parseLong(bf.readLine());
		new FavoritesDaoSqlImpl().addFavoriteMovie(userId, movieId);
	}

	public static void testRemoveFavorites() throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the userId");
		long userId = Long.parseLong(bf.readLine());
		System.out.println("Enter the Movie Id");
		long movieId = Long.parseLong(bf.readLine());
		new FavoritesDaoSqlImpl().removeFavoriteMovie(userId, movieId);
	}

	public static void testGetAllFavorites() throws FavoriteEmptyException, NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the userId");
		long userId = Long.parseLong(bf.readLine());
		Favorites favorites = new FavoritesDaoSqlImpl().getFavoriteMovie(userId);
		System.out.println(favorites.getMovieList());
	}

	public static void main(String[] args) throws NumberFormatException, IOException, FavoriteEmptyException {
		testAddToFavorites();
		testRemoveFavorites();
		testGetAllFavorites();
	}
}