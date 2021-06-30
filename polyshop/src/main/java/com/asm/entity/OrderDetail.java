package com.asm.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Data;
@SuppressWarnings("serial")
@Data
@Entity 
@Table(name = "orderdetail",uniqueConstraints = {@UniqueConstraint(columnNames = {"productid","orderid"})})
public class OrderDetail  implements Serializable{
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 Integer id;
 @ManyToOne
 @JoinColumn(name = "productid")
 Product product;
 @ManyToOne
 @JoinColumn(name = "orderid")
 Order order;
 Float price;
 Integer quantity;
}
