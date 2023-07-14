package com.rivaldy.dans.dto.request;

import com.rivaldy.dans.enumerate.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record RegisterRequest(@Size(min = 10, max = 50, message = "first name min 10 max 10") String firstname,
                              @Size(min = 10, max = 50, message = "last name min 10 max 10") String lastname,
                              @Email String email,
                              String password, Role role) {
}
