package com.asm.DAO;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.asm.entity.OrderDetail;

public interface orderDetailDAO extends JpaRepository<OrderDetail, Integer> {

	@Query(value = "SELECT * FROM orderdetail WHERE orderid = ?1",nativeQuery = true)
	List<OrderDetail> findByOrderId(@Param("id") Integer id);
}
