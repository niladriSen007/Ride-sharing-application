package com.niladri.RideSharingApplication.exception;

import com.niladri.RideSharingApplication.dto.apiResponse.ApiDataResponse;
import com.niladri.RideSharingApplication.dto.errors.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiDataResponse<?>> handleMyMethodArgumentNotValidException
			(MethodArgumentNotValidException e){
		Map<String, String> errors = new HashMap<>();
		e.getBindingResult().getAllErrors().forEach(error ->{
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName,errorMessage);
		});
		ApiErrorResponse apiError = ApiErrorResponse.builder().
				status(HttpStatus.BAD_REQUEST).
				message("Input validation failed").
				subErrors(errors).build();
		return buildErrorResponseDto(apiError);

	}


	@ExceptionHandler(UserAlreadyExists.class)
	public ResponseEntity<ApiDataResponse<?>> handleUserAlreadyExists(UserAlreadyExists e){
		ApiErrorResponse apiError = ApiErrorResponse.builder().
				status(HttpStatus.BAD_REQUEST).
				message(e.getMessage()).build();
		return buildErrorResponseDto(apiError);
	}

	@ExceptionHandler(UserNotFound.class)
	public ResponseEntity<ApiDataResponse<?>> handleUserNotFoundException(UserNotFound e){
		ApiErrorResponse apiError = ApiErrorResponse.builder().
				status(HttpStatus.NOT_FOUND).
				message(e.getMessage()).build();
		return buildErrorResponseDto(apiError);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiDataResponse<?>> handleException(Exception e){
		ApiErrorResponse apiError = ApiErrorResponse.builder().
				status(HttpStatus.INTERNAL_SERVER_ERROR).
				message(e.getMessage()).build();
		return buildErrorResponseDto(apiError);
	}

	private ResponseEntity<ApiDataResponse<?>> buildErrorResponseDto(ApiErrorResponse apiError){
		return new ResponseEntity<>(new ApiDataResponse<>(apiError),apiError.getStatus());
	}
}
