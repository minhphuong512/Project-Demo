package com.asm.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO implements Serializable{
	 Integer id;
	 String name;
	 String image;
	 Float price;
	 Date createDate;
	 Boolean available;
	 Integer CateId;
	 float discount;
	 Integer quantity;
	 String infor;
}
