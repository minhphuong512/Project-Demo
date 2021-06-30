package com.asm.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.asm.entity.Order;

public interface orderDAO extends JpaRepository<Order,Integer> {
	
//	@Query("SELECT p FROM orders p WHERE p.id = :id")
//	List<Order> findByOrder(@Param("id") Integer id);

	@Query(value = "SELECT * FROM orders WHERE id_account = ?1",nativeQuery = true)
	List<Order> findByOrder(@Param("accId") Integer accId);
}
