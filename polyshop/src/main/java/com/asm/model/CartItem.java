package com.asm.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
	Integer id;
	 String name;
	 String image;
	 Float price;
	 Date createDate = new Date();
	 Integer CategoryId;
	 float discount;
	 Integer quantity;
	 boolean avaliable;
	 
}
