
package com.cognizant.moviecruiser.dao;

import com.cognizant.moviecruiser.model.Favorites;

public interface FavoritesDao {

	public void addFavoriteMovie(long userId, long movieId);

	public void removeFavoriteMovie(long userId, long movieId);

	public Favorites getFavoriteMovie(long userId) throws FavoriteEmptyException;

}
