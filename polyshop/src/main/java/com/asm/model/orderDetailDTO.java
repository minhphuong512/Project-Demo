package com.asm.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class orderDetailDTO implements Serializable{
	
	Integer id;
	Integer productid;
	 Integer orderid;
	 Float price;
	 Integer quantity;
}
