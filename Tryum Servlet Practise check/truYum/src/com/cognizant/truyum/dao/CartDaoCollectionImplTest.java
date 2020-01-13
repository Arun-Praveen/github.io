package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {

	public static void testAddCartItem() throws CartEmptyException {
		// 1. Instantiate CartDaoCollectionImpl and assign it to CartDao reference
		// variable cartDao.
		CartDao cartDao = new CartDaoCollectionImpl();
		// 2. Invoke cartDao.addCartItem()
		cartDao.addCartItem(1, 2L);
		cartDao.addCartItem(1, 5L);

		cartDao.addCartItem(2, 1L);
		cartDao.addCartItem(2, 3L);

		@SuppressWarnings("unchecked")
		List<MenuItem> menuItemListCustomer = (List<MenuItem>) cartDao.getAllCartItems(1);
		System.out.println("User added cart list for checkout");
		for (MenuItem menuItem : menuItemListCustomer) {
			System.out.println(menuItem);
		}
	}

	public static void testRemoveCartItem() throws CartEmptyException {
		// 1. Instantiate CartDaoCollectionImpl and assign it CartDao reference variable
		// cartDao.
		CartDao cartDao = new CartDaoCollectionImpl();
		// 2. Invoke cartDao.removeCartItem()
		try {
			cartDao.removeCartItem(1, 2L);
			cartDao.removeCartItem(1, 5L);
			cartDao.removeCartItem(1, 3L);
			// 3. Invoke cartDao.getAllCartItems() with userId as 1 &2
			@SuppressWarnings("unchecked")
			List<MenuItem> menuItemListCustomer = (List<MenuItem>) cartDao.getAllCartItems(1);

			for (MenuItem menuItem : menuItemListCustomer) {

				System.out.println("Menu after removing\n" + menuItem);
			}
		} catch (CartEmptyException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void testGetAllCartItems() {

	}

	public static void main(String args[]) throws CartEmptyException {

		testAddCartItem();
		testRemoveCartItem();
	}

}