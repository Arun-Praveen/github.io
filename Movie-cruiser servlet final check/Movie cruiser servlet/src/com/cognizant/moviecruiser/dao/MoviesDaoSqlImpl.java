package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecruiser.model.Movies;
import com.cognizant.moviecruiser.util.DateUtil;

public class MoviesDaoSqlImpl implements MoviesDao {

	public static final String GET_MOVIES_ADMIN = "select * from movie_cruiser.movie_list;";
	public static final String GET_MOVIES_CUSTOMER = "select * from movie_cruiser.movie_list where mo_active='1' and mo_date_of_launch > (select curdate());";
	public static final String UPDATE_MOVIES = "update movie_cruiser.movie_list set " + "mo_title=?, "
			+ "mo_box_office=?, " + "mo_active=?, " + "mo_date_of_launch=?, " + "mo_genre=?, " + "mo_has_teaser=? "
			+ "where mo_id=?;";
	public static final String GET_MOVIES = "select * from movie_cruiser.movie_list where mo_id=?;";

	public List<Movies> getMoviesListAdmin() {
		ArrayList<Movies> movieList = new ArrayList<>();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = ConnectionHandler.getConnection();
		try {
			statement = connection.prepareStatement(GET_MOVIES_ADMIN);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Movies movies = new Movies();
				movies.setId(resultSet.getLong("mo_id"));
				movies.setTitle(resultSet.getString("mo_title"));
				movies.setGross(resultSet.getLong("mo_box_office"));
				movies.setActive(resultSet.getString("mo_active").equals("1"));
				movies.setDateOfLaunch(resultSet.getDate("mo_date_of_launch"));
				movies.setGenre(resultSet.getString("mo_genre"));
				movies.setTeaser(resultSet.getString("mo_has_teaser").equals("1"));
				movieList.add(movies);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
			}
		}

		return movieList;
	}

	public List<Movies> getMoviesListCustomer() {
		ArrayList<Movies> movieList = new ArrayList<>();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = ConnectionHandler.getConnection();
		try {
			statement = connection.prepareStatement(GET_MOVIES_CUSTOMER);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Movies movies = new Movies();
				movies.setId(resultSet.getLong("mo_id"));
				movies.setTitle(resultSet.getString("mo_title"));
				movies.setGross(resultSet.getLong("mo_box_office"));
				movies.setActive(resultSet.getString("mo_active").equals("1"));
				movies.setDateOfLaunch(resultSet.getDate("mo_date_of_launch"));
				movies.setGenre(resultSet.getString("mo_genre"));
				movies.setTeaser(resultSet.getString("mo_has_teaser").equals("1"));
				movieList.add(movies);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
			}
		}

		return movieList;
	}

	public void modifyMovies(Movies movies) {
		System.out.println(movies);
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(UPDATE_MOVIES);
			statement.setString(1, movies.getTitle());
			statement.setLong(2, movies.getGross());
			statement.setString(3, movies.isActive() ? "1" : "0");
			statement.setDate(4, new DateUtil().convertToSqlDate(movies.getDateOfLaunch()));
			statement.setString(5, movies.getGenre());
			statement.setString(6, movies.isTeaser() ? "1" : "0");
			statement.setLong(7, movies.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("User Not Found");
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}

	}

	public Movies getMovies(long moviesId) {

		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = ConnectionHandler.getConnection();
		Movies movies = null;
		try {
			statement = connection.prepareStatement(GET_MOVIES);
			statement.setLong(1, moviesId);
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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {

			}
		}
		return movies;
	}
}
