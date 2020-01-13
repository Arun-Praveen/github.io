package com.cognizant.truyum.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import com.cognizant.truyum.model.Cart;

public class CartDaoSqlImplTest {

	public static void testAddToCart() throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the userId");
		long userId = Long.parseLong(bf.readLine());
		System.out.println("Enter the MenuItem Id");
		long menuItemId = Long.parseLong(bf.readLine());
		new CartDaoSqlImpl().addCartItem(userId, menuItemId);
	}
	
	public static void testRemoveFromCart() throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the userId");
		long userId = Long.parseLong(bf.readLine());
		System.out.println("Enter the MenuItem Id");
		long menuItemId = Long.parseLong(bf.readLine());
		new CartDaoSqlImpl().removeCartItem(userId, menuItemId);
		
	}	
	
	public static void testAllGetCartItems() throws CartEmptyException, NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the userId");
		long userId = Long.parseLong(bf.readLine());
		Cart cart = new CartDaoSqlImpl().getAllCartItems(userId);
		System.out.println(cart.getMenuItemList());
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException, CartEmptyException {
		testAddToCart();
		testRemoveFromCart();
		testAllGetCartItems();
	}
}