package com.ecommerce.demo.dto;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StoreDto {

	private String id;
	private String name;
	private String image;
    private Date created_at;
}
