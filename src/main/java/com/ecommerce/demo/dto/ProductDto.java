package com.ecommerce.demo.dto;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {

	public String id;
    public String name;
    public String image;
    public String price;
    public String amount;
    public String link;
    public String description;
    public Date createdAt;
}
