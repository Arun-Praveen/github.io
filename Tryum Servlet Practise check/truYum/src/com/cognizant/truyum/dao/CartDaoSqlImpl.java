package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao {

	public static final String ADD_CART = "INSERT INTO truyum_sql.cart (ct_us_id, ct_me_id) VALUES (?, ?);";
	public static final String GET_CART_ITEMS = "select * from truyum_sql.menu_item inner join truyum_sql.cart on cart.ct_me_id = menu_item.me_id where cart.ct_us_id=?;";
	public static final String GET_TOTAL_FROM_CART = "select sum(menu_item.me_price) as Total from menu_item inner join cart on menu_item.me_id=cart.ct_me_id where cart.ct_us_id= ?";
	public static final String DELETE_CART = "delete  from truyum_sql.cart where ct_us_id=? and ct_me_id=? limit 1";

	@Override
	public void addCartItem(long userId, long menuItemId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(ADD_CART);
			statement.setLong(1, userId);
			statement.setLong(2, menuItemId);
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

	@Override
	public Cart getAllCartItems(long userId) throws CartEmptyException {
		Connection connection = ConnectionHandler.getConnection();
		ArrayList<MenuItem> cartList = new ArrayList<MenuItem>();
		Cart cart = new Cart();
		PreparedStatement statement = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ResultSet resultSetTotal = null;
		MenuItem menuItem = null;
		try {
			statement = connection.prepareStatement(GET_CART_ITEMS);
			statement.setLong(1, userId);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				menuItem = new MenuItem();
				menuItem.setId(resultSet.getLong("me_id"));
				menuItem.setName(resultSet.getString("me_name"));
				menuItem.setPrice(resultSet.getFloat("me_price"));
				menuItem.setActive(resultSet.getString("me_active").equals("1"));
				menuItem.setDateOfLaunch(resultSet.getDate("me_date_of_launch"));
				menuItem.setCategory(resultSet.getString("me_category"));
				menuItem.setFreeDelivery(resultSet.getString("me_free_delivery").equals("1"));

				cartList.add(menuItem);
			}
			cart.setMenuItemList(cartList);

			preparedStatement = connection.prepareStatement(GET_TOTAL_FROM_CART);
			preparedStatement.setLong(1, userId);
			resultSetTotal = preparedStatement.executeQuery();
			if (cartList.size() == 0) {
				throw new CartEmptyException();
			}
			while (resultSetTotal.next()) {
				cart.setTotal(resultSetTotal.getDouble("Total"));
			}

		} catch (SQLException e) {
			throw new CartEmptyException();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (resultSetTotal != null) {
					resultSetTotal.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
		return cart;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(DELETE_CART);
			statement.setLong(1, userId);
			statement.setLong(2, menuItemId);
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

}