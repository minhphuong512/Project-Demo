package com.asm.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.asm.entity.Account;


public interface accountDAO extends JpaRepository<Account,Integer> {
	
	@Query("SELECT entity FROM Account entity WHERE username = :username and password = :password")
	public Account findByAcc(@Param("username") String username,@Param("password") String password);
}
