package com.asm.DAO;

import org.springframework.data.jpa.repository.JpaRepository;



import com.asm.entity.Category;

public interface categoryDAO extends JpaRepository<Category, Integer> {
	
}
