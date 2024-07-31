package com.jsp.boot_user.dto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.boot_user.dao.User;
import com.jsp.boot_user.repo.UserRepo;

@Repository
public class UserCurd {
	@Autowired
	UserRepo repo;

	public User save(User u) {
		return repo.save(u);
	}

	public User findById(int id) {
		Optional<User> u = repo.findById(id);
		if(u.isPresent()) {
			return u.get();
		}else {
			return null;
		}
	}

	public User deleteUser(int id) {
		Optional<User> u = repo.findById(id);
		if(u!=null) {
			repo.delete(u.get());
			return u.get();
		}else {
			return null;
		}
	}

	public User deleteByEmail(String email) {
		User u = repo.findByEmail(email);
		if(u!=null) {
			repo.delete(u);
			return u;
		}else {
			return null;
		}
	}

	public User updateUser(User u) {
		return repo.save(u);
	}

	public List<User> findByAll() {
		return repo.findAll();
	}

	public User findByEmail(String email) {
		return repo.findByEmail(email);
	}

}
