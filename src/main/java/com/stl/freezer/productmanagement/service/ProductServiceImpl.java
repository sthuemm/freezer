package com.stl.freezer.productmanagement.service;

import com.stl.freezer.productmanagement.model.Product;
import com.stl.freezer.productmanagement.model.ProductDto;
import com.stl.freezer.productmanagement.populator.ProductPopulator;
import com.stl.freezer.productmanagement.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;
import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final String TAG = this.getClass().getSimpleName();

    final private ProductRepository productRepository;

    final private ProductPopulator productPopulator;


    ProductServiceImpl(ProductRepository productRepository, ProductPopulator productPopulator){
        this.productRepository = productRepository;
        this.productPopulator = productPopulator;
    }


    @Override
    @Nullable
    public ProductDto saveProduct(@Nullable Product product) {
        if(product == null){
            log.error(TAG + ": product must not be null");
            return null;
        }
        Product persistedProduct = productRepository.save(product);
        return productPopulator.convertToDto(persistedProduct);
    }

    @Override
    public ProductDto getProduct(long id) {
        return productPopulator.convertToDto(productRepository.findOne(id));
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
