package com.asm.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.asm.DAO.cartItemDAO;
import com.asm.model.CartItem;

@Service
@SessionScope
public class cartItemImpl implements cartItemDAO {

	public Map<Integer, CartItem> map = new HashMap<Integer, CartItem>();

	@Override
	public void add(CartItem item) {
		CartItem existedItem = map.get(item.getId());

		if (existedItem != null) {
			existedItem.setQuantity(item.getQuantity() + existedItem.getQuantity());
		} else {
			map.put(item.getId(), item);
		}
	}

	@Override
	public void remove(int id) {
		map.remove(id);
	}

	@Override
	public Collection<CartItem> getCartItem() {
		return map.values();
	}

	@Override
	public void clean() {
		map.clear();
	}
	
	@Override
	public void update(int id , int qty) {
	 	CartItem item = map.get(id);
		item.setQuantity( qty );
		
		if(item.getQuantity() <= 0) {
			map.remove(id);
			
		}
	}
	
	@Override
	public double getAmount() {
		 return map.values().stream().mapToDouble(item -> item.getQuantity() * item.getPrice()).sum();
	}
	
	@Override
	public int getCount() {
		if(map.isEmpty()) {
			return 0;
		}
		
		return map.values().size();
	}

}
