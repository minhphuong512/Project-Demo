package com.asm.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class orderDTO implements Serializable{

	 Integer id;
	 Integer accId;
	 Date createDate;
	 String address;
	 
}
