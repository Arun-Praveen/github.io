package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImpl implements MenuItemDao {
	public static final String GET_MENU_ITEM_ADMIN = "select * from menu_item";
	public static final String GET_MENU_ITEM_CUSTOMER = "select * from truyum_sql.menu_item where me_active='1' and me_date_of_launch > (select curdate());";
	public static final String UPDATE_MENU_ITEM = "update menu_item set " + "me_name=?, " + "me_price=?, "
			+ "me_active=?, " + "me_date_of_launch=?, " + "me_category=?, " + "me_free_delivery=? " + "where me_id=?";
	public static final String GET_MENU_ITEM_LIST = "select * from menu_item where me_id=?";

	public List<MenuItem> getMenuItemListAdmin() {
		ArrayList<MenuItem> menuItemList = new ArrayList<>();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = ConnectionHandler.getConnection();
		try {
			statement = connection.prepareStatement(GET_MENU_ITEM_ADMIN);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				MenuItem menuItem = new MenuItem();
				menuItem.setId(resultSet.getLong("me_id"));
				menuItem.setName(resultSet.getString("me_name"));
				menuItem.setPrice(resultSet.getFloat("me_price"));
				menuItem.setActive(resultSet.getString("me_active").equals("1"));
				menuItem.setDateOfLaunch(resultSet.getDate("me_date_of_launch"));
				menuItem.setCategory(resultSet.getString("me_category"));
				menuItem.setFreeDelivery(resultSet.getString("me_free_delivery").equals("1"));
				menuItemList.add(menuItem);
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

		return menuItemList;
	}

	public List<MenuItem> getMenuItemListCustomer() {
		ArrayList<MenuItem> menuItemList = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(GET_MENU_ITEM_CUSTOMER);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				MenuItem menuItem = new MenuItem();
				menuItem.setId(resultSet.getLong("me_id"));
				menuItem.setName(resultSet.getString("me_name"));
				menuItem.setPrice(resultSet.getFloat("me_price"));
				menuItem.setActive(resultSet.getString("me_active").equals("1"));
				menuItem.setDateOfLaunch(resultSet.getDate("me_date_of_launch"));
				menuItem.setCategory(resultSet.getString("me_category"));
				menuItem.setFreeDelivery(resultSet.getString("me_free_delivery").equals("1"));
				menuItemList.add(menuItem);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
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
		return menuItemList;
	}

	public void modifyMenuItem(MenuItem menuItem) {
		System.out.println(menuItem);
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(UPDATE_MENU_ITEM);
			statement.setString(1, menuItem.getName());
			statement.setFloat(2, menuItem.getPrice());
			statement.setString(3, menuItem.getActive() ? "1" : "0");
			statement.setDate(4, new DateUtil().convertToSqlDate(menuItem.getDateOfLaunch()));
			statement.setString(5, menuItem.getCategory());
			statement.setString(6, menuItem.getFreeDelivery() ? "1" : "0");
			statement.setLong(7, menuItem.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("User Not Found");
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
	}

	public MenuItem getMenuItem(Long menuItemId) {

		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = ConnectionHandler.getConnection();
		MenuItem menuItem = null;
		try {
			statement = connection.prepareStatement(GET_MENU_ITEM_LIST);
			statement.setLong(1, menuItemId);
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
		return menuItem;
	}
}
