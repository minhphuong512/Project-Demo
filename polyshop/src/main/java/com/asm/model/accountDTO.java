package com.asm.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class accountDTO implements Serializable{
	Integer id;
	String username;
	String password;
	 String fullname;
	 String email;
	 String photo;
	 Integer activated;
	 Integer admin;
}







