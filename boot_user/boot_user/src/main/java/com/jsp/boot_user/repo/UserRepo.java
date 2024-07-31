package com.jsp.boot_user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.boot_user.dao.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	@Query("select a from User a where email=?1")
	User findByEmail(String email);

	@Query("delete from User where email=?1")
	User deleteByEmail(String email);
}
