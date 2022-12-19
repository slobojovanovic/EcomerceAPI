package com.ecommerce.demo.exceptions;

import org.springframework.web.client.RestClientException;

public class ApiIsNotAvailable extends RestClientException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ApiIsNotAvailable(String msg) {
		super(msg);
	}

}
