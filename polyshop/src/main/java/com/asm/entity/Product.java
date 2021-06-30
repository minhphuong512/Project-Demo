package com.asm.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity @Table(name = "products")
public class Product  implements Serializable{
 @Id 
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 Integer id;
 String name;
 String image;
 Float price;
 @Temporal(TemporalType.DATE)
 @Column(name = "createdate")
 Date createDate = new Date();
 Boolean available;
 @ManyToOne
 @JoinColumn(name = "category_id")
 Category category;
 @Column(name = "discount")
 float discount;
 @Column(name = "quantity")
 Integer quantity;
 String infor;
 @JsonIgnore
 @OneToMany(mappedBy = "product")
 List<OrderDetail> orderDetails; 
}
