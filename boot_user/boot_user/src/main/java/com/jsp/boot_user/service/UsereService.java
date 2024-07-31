package com.jsp.boot_user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.boot_user.dao.User;
import com.jsp.boot_user.dto.UserCurd;
import com.jsp.boot_user.exception.UserNotFound;
import com.jsp.boot_user.util.ResponseStructure;

@Service
public class UsereService {
	@Autowired
	UserCurd curd;

	public ResponseEntity<ResponseStructure<User>> SaveUser(User u) {
		ResponseStructure<User> rs = new ResponseStructure<User>();
		rs.setStateCode(HttpStatus.CREATED.value());
		rs.setData(curd.save(u));
		rs.setMessage("User saved Sucessfully..!");
		return new ResponseEntity<ResponseStructure<User>>(rs, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<User>> findById(int id) {
		User u=curd.findById(id);
		if(u!=null) {
			ResponseStructure<User> rs = new ResponseStructure<User>();
			rs.setStateCode(HttpStatus.CREATED.value());
			rs.setData(u);
			rs.setMessage("User find  Sucessfully..!");
			return new ResponseEntity<ResponseStructure<User>>(rs, HttpStatus.CREATED);
		}else {
			throw new UserNotFound("User id:"+id+" Not found display..!");
		}
	}

	public ResponseEntity<ResponseStructure<User>> findByEmail(String email) {
		User u=curd.findByEmail(email);
		if(u!=null) {
			ResponseStructure<User> rs = new ResponseStructure<User>();
			rs.setStateCode(HttpStatus.CREATED.value());
			rs.setData(u);
			rs.setMessage("User find  Sucessfully..!");
			return new ResponseEntity<ResponseStructure<User>>(rs, HttpStatus.CREATED);
		}else {
			throw new UserNotFound("User email:"+email+" Not found display..!");
		}
	}

	public ResponseEntity<ResponseStructure<User>> delete(int id) {
		User u=curd.deleteUser(id);
		if(u!=null) {
			ResponseStructure<User> rs = new ResponseStructure<User>();
			rs.setStateCode(HttpStatus.CREATED.value());
			rs.setData(u);
			rs.setMessage("User delete  Sucessfully..!");
			return new ResponseEntity<ResponseStructure<User>>(rs, HttpStatus.CREATED);
		}else {
			throw new UserNotFound("User id:"+id+" is not present ..!");
		}
	}

	public ResponseEntity<ResponseStructure<User>> delete(String email) {
		User u=curd.deleteByEmail(email);
		if(u!=null) {
			ResponseStructure<User> rs = new ResponseStructure<User>();
			rs.setStateCode(HttpStatus.CREATED.value());
			rs.setData(u);
			rs.setMessage("User delete  Sucessfully..!");
			return new ResponseEntity<ResponseStructure<User>>(rs, HttpStatus.CREATED);
		}else {
			throw new UserNotFound("User email:"+email+" is not present ..!");
		}
	}
}
