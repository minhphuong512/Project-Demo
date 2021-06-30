package com.asm.DAO;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.asm.entity.Product;



public interface productDAO extends JpaRepository<Product, Integer> {

	@Query("SELECT p FROM Product p WHERE p.category.id = :categoryId")
	List<Product> findByCategoryId(@Param("categoryId") Integer categoryId);
	
	@Query("SELECT p FROM Product p WHERE p.category.id = :categoryId")
	Page<Product> findByCaIdOrPage(@Param("categoryId") Integer categoryId,Pageable page);
	
	@Query("SELECT p FROM Product p WHERE p.name LIKE :name")
	List<Product> findByName(@Param("name") String name);
	

}
