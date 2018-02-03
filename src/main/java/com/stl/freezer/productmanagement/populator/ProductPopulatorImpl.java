package com.stl.freezer.productmanagement.populator;


import com.stl.freezer.productmanagement.model.Product;
import com.stl.freezer.productmanagement.model.ProductDto;
import org.springframework.stereotype.Service;

@Service
public class ProductPopulatorImpl implements ProductPopulator {

    @Override
    public ProductDto convert(Product product) {
        ProductDto newProductDto = new ProductDto();
        newProductDto.setId(product.getId());
        newProductDto.setName(product.getName());
        newProductDto.setQuantity(product.getQuantity());

        return newProductDto;
    }

}
