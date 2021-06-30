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
import lombok.Data;
@SuppressWarnings("serial")
@Data
@Entity 
@Table(name = "orders")
public class Order  implements Serializable{
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 Integer id;
 @ManyToOne
 @JoinColumn(name = "id_account")
 Account account;
 @Temporal(TemporalType.DATE)
 @Column(name = "createdate")
 Date createDate = new Date();
 @Column(name = "amount")
 double amount;
 String address;
 Integer status;
 
 
 @JsonIgnore
 @OneToMany(mappedBy = "order")
 List<OrderDetail> orderDetails;
}
