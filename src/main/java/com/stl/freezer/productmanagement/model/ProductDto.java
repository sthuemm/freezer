package com.stl.freezer.productmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductDto {

    private Long id;

    private String name;

    private int quantity;

    public ProductDto(){}

}
