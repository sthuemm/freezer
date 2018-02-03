package com.stl.freezer.productmanagement.service;

import com.stl.freezer.productmanagement.model.Product;
import com.stl.freezer.productmanagement.model.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    ProductDto saveProduct(Product product);

    ProductDto getProduct(long id);

    List<Product> getAllProducts();

    List<Product> getAllProductsDescendingByQuantity();

}
