package com.jsp.boot_user.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserNotFound extends RuntimeException{
	private String message="User not found";
	public UserNotFound(String string) {
		super(string);
		this.message=string;
	}
	
}
