package com.bootcamp.library.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {
	 	@Size(min = 3, max = 10, message = "First name contains 3-10 characters")
	    private String firstName;
	    @Size(min = 3, max = 10, message = "Last name contains 3-10 characters")
	    private String lastName;
	    private String userName;
	    @Size(min = 8, max = 20, message = "Password contains 8-20 characters")
	    private String password;
	    private String repeatPassword;
}
