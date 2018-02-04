package com.stl.freezer.productmanagement.populator;

import com.stl.freezer.productmanagement.model.Product;
import com.stl.freezer.productmanagement.model.ProductDto;

public interface ProductPopulator {

    ProductDto convertToDto(Product product);
    Product convertToEntity(ProductDto productDto);

}
