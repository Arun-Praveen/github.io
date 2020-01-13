package com.cognizant.truyum.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoSqlImplTest {

	public static void testGetMenuItemListAdmin() {
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem);
		}
	}

	public static void testGetMenuListCustomer() {

		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListCustomer();
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem);
		}

	}
	
	public static void testModifyItem() throws NumberFormatException, IOException, ParseException, SQLException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Enter the user Id to update");
		long userId = Long.parseLong(bf.readLine());
		System.out.println("Enter the name to update");
		String name = bf.readLine();
		System.out.println("Enter price to update");
		float price = Float.parseFloat(bf.readLine());
		System.out.println("Enter active status to update");
		boolean active = Boolean.parseBoolean(bf.readLine());
		System.out.println("Enter Date to update");
		String date = bf.readLine();
        Date dateOfLaunch = df.parse(date);
        System.out.println("Enter category to update");
        String category = bf.readLine();
        System.out.println("Enter delivery status to update");
		boolean freeDelivery = Boolean.parseBoolean(bf.readLine());
		MenuItem menuItem = new MenuItem(userId, name, price, active, dateOfLaunch, category, freeDelivery);
		new MenuItemDaoSqlImpl().modifyMenuItem(menuItem);
		System.out.println("Success");
	}
	
	public static void testGetMenuItem() throws NumberFormatException, IOException {
		
		System.out.println("Enter the id");
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		long menuItemId = Long.parseLong(bf.readLine());
		MenuItem menuItem = new MenuItemDaoSqlImpl().getMenuItem(menuItemId);
        System.out.println(menuItem);

	}

	public static void main(String[] args) throws NumberFormatException, IOException, ParseException, SQLException {
		testGetMenuItemListAdmin();
		testGetMenuListCustomer();
		testModifyItem();
		testGetMenuItem();
	}

}