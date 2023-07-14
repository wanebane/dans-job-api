package com.rivaldy.dans.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;

public record ApiResponse(boolean success, String message, Object data, @JsonIgnore HttpStatus status) {
}
