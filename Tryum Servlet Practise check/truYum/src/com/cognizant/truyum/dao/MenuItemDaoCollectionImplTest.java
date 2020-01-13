package com.cognizant.truyum.dao;

import java.sql.SQLException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {

	public static void testGetMenuItemListAdmin() {
		System.out.println("Item List for admin");
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem);
			// System.out.println(new
			// DateUtil().convertToString(menuItem.getDateOfLaunch()));
		}
	}

	public static void testGetMenuItemListCustomer() {
		System.out.println("Item List For Customer");
		// 1. Instantiate MenuItemDaoCollecionimpl and assign it MenuItemDao reference
		// variable menuItemDao.
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		// 2. Invoke menuItemDao.getMenuItemListAdmin() and obtain the menuItemList
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListCustomer();
		// 3. Iterate through the menuitemList and display all attributes of each item
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem);
		}
	}

	public static void testModifyMenuItem() throws SQLException {
		// 1. Create an instance for Menu Item with id matching with one of the menu
		// item already added to the menuItemList.
		MenuItem item = new MenuItem(5L, "Briyani", 520.00f, true, new DateUtil().convertToDate("02/11/2022"), "Rice",
				true);
		// 2. Instantiate MenuItemDaoCollectionImpl and assign it MenuItemDao reference
		// variable menuItemDao.
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		// 3. Invoke MenuItemDao.modifyMenuItem(menuItem) by passing the menu item
		// created in the first step.
		menuItemDao.modifyMenuItem(item);
		System.out.println("Modified List");
		testGetMenuItemListAdmin();
		MenuItem modified_Item = menuItemDao.getMenuItem(item.getId());
		System.out.println("Modified Item Details\n" + modified_Item);
	}

	public static void main(String args[]) throws SQLException {

		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();
	}

}