package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movies;

public class FavoritesDaoSqlImpl implements FavoritesDao {

	public static final String ADD_FAVORITES = "INSERT INTO `movie_cruiser`.`favorites` (`fav_us_id`, `fav_mo_id`) VALUES (?, ?);";
	public static final String REMOVE_FAVORITES = "delete  from movie_cruiser.favorites where fav_us_id=? and fav_mo_id=? limit 1";
	public static final String GET_FAVORITES = "select * from movie_cruiser.movie_list inner join movie_cruiser.favorites on favorites.fav_mo_id=movie_list.mo_id where favorites.fav_us_id=?;";
	public static final String GET_TOTAL_FAVORITES = "select count(mo_box_office) as Total from movie_cruiser.movie_list inner join movie_cruiser.favorites on fav_mo_id=mo_id where fav_us_id=?;";

	public void addFavoriteMovie(long userId, long movieId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(ADD_FAVORITES);
			statement.setLong(1, userId);
			statement.setLong(2, movieId);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
		return;
	}

	public void removeFavoriteMovie(long userId, long movieId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(REMOVE_FAVORITES);
			statement.setLong(1, userId);
			statement.setLong(2, movieId);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
		return;
	}

	public Favorites getFavoriteMovie(long userId) throws FavoriteEmptyException {
		Connection connection = ConnectionHandler.getConnection();
		ArrayList<Movies> movieList = new ArrayList<Movies>();
		Favorites favorites = new Favorites();
		PreparedStatement statement = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ResultSet resultSetTotal = null;
		Movies movies = null;
		try {
			statement = connection.prepareStatement(GET_FAVORITES);
			statement.setLong(1, userId);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				movies = new Movies();
				movies.setId(resultSet.getLong("mo_id"));
				movies.setTitle(resultSet.getString("mo_title"));
				movies.setGross(resultSet.getLong("mo_box_office"));
				movies.setActive(resultSet.getString("mo_active").equals("1"));
				movies.setDateOfLaunch(resultSet.getDate("mo_date_of_launch"));
				movies.setGenre(resultSet.getString("mo_genre"));
				movies.setTeaser(resultSet.getString("mo_has_teaser").equals("1"));
				movieList.add(movies);
			}
			favorites.setMovieList(movieList);
			preparedStatement = connection.prepareStatement(GET_TOTAL_FAVORITES);
			preparedStatement.setLong(1, userId);
			resultSetTotal = preparedStatement.executeQuery();
			if (movieList.size() == 0) {
				throw new FavoriteEmptyException();
			}
			while (resultSetTotal.next()) {
				favorites.setNoOfFavorites(resultSetTotal.getDouble("Total"));
			}

		} catch (SQLException e) {
			throw new FavoriteEmptyException();
		}
		try {
			if (connection != null) {
				connection.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (preparedStatement != null) {
				statement.close();
			}
			if (resultSet != null) {
				resultSet.close();
			}
			if (resultSetTotal != null) {
				resultSetTotal.close();
			}

		} catch (SQLException e) {
			// TODO: handle exception
		}

		return favorites;
	}

}