package com.niladri.RideSharingApplication.dto.apiResponse;

import com.niladri.RideSharingApplication.dto.errors.ApiErrorResponse;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiDataResponse<T> {
	private LocalDateTime timeStamp;
	private T data;
	private ApiErrorResponse error;

	public ApiDataResponse(){
		this.timeStamp = LocalDateTime.now();
	}

	public ApiDataResponse(T data){
		this();
		this.data = data;
	}
	public ApiDataResponse(ApiErrorResponse error){
		this();
		this.error = error;
	}



}
