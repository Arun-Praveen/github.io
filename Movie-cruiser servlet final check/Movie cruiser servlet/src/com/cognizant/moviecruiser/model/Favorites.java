package com.cognizant.moviecruiser.model;

import java.util.List;

public class Favorites {

	private static List<Movies> movieList;
	private double noOfFavorites;
	public Object getMovies;

	public List<Movies> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movies> movieList) {
		Favorites.movieList = movieList;
	}

	public double getNoOfFavorites() {
		return noOfFavorites;
	}

	public void setNoOfFavorites(double noOfFavorites) {
		this.noOfFavorites = noOfFavorites;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(noOfFavorites);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Favorites other = (Favorites) obj;
		if (Double.doubleToLongBits(noOfFavorites) != Double.doubleToLongBits(other.noOfFavorites))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Favorites [noOfFavorites=" + noOfFavorites + "]";
	}

}