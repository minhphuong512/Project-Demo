package com.asm.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
@SuppressWarnings("serial")
@Data
@Entity 
@Table(name = "accounts")
public class Account  implements Serializable{
	
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 Integer id;
@Column(name = "username")
 String username;
@Column(name = "password")
 String password;
@Column(name = "fullname")
 String fullname;
@Column(name = "email")
 String email;
@Column(name = "photo")
 String photo;
@Column(name = "activated")
 Integer activated;
@Column(name = "admin")
 Integer admin;
 @OneToMany(mappedBy = "account")
 List<Order> order;
}
