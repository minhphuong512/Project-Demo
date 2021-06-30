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
import lombok.Data;
@SuppressWarnings("serial")
@Data
@Entity 
@Table(name = "categories")
public class Category implements Serializable{
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "id")
 Integer id;
 
 @Column(name = "catename")
 String nameCa;
 
 @OneToMany(mappedBy = "category")
 List<Product> product;
}
