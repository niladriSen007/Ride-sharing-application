package com.niladri.RideSharingApplication.dto.errors;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Data
@Builder
public class ApiErrorResponse {
	private HttpStatus status;
	private String message;
	private Map<String,String> subErrors;
}
