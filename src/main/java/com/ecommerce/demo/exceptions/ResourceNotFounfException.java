package com.ecommerce.demo.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFounfException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String resourceName;
    String fieldName;
    String fieldValue;

    public ResourceNotFounfException(String resourceName, String fieldName, String fieldValue) {
        super(String.format("%s nije pronadjen sa %s : %s ", 
                resourceName,fieldName, fieldValue));

        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
