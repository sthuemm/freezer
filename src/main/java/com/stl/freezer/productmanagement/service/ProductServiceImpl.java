package com.stl.freezer.productmanagement.service;

import com.stl.freezer.productmanagement.model.Product;
import com.stl.freezer.productmanagement.model.ProductDto;
import com.stl.freezer.productmanagement.populator.ProductPopulator;
import com.stl.freezer.productmanagement.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    final private ProductRepository productRepository;

    final private ProductPopulator productPopulator;

    ProductServiceImpl(ProductRepository productRepository, ProductPopulator productPopulator){
        this.productRepository = productRepository;
        this.productPopulator = productPopulator;
    }

    @Override
    public ProductDto saveProduct(Product product) {
        return productPopulator.convert(productRepository.save(product));
    }

    @Override
    public ProductDto getProduct(long id) {
        return productPopulator.convert(productRepository.findOne(id));
    }

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public List<Product> getAllProductsDescendingByQuantity() {
        List<Product> products = (List<Product>) productRepository.findAll();
        products.sort((product1, product2) -> {
            if(product1.getQuantity() < product2.getQuantity()){
                return -1;
            } else if (product2.getQuantity() < product1.getQuantity()){
                return 1;
            } else {
                return 0;
            }
        });
        return products;
    }
}
