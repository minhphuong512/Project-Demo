package com.asm.DAO;

import java.util.Collection;

import com.asm.model.CartItem;

public interface cartItemDAO {
	int getCount();

	double getAmount();

	void update(int id, int qty);

	void clean();

	Collection<CartItem> getCartItem();

	void remove(int id);

	void add(CartItem item);
}
