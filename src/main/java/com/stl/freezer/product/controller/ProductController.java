package com.stl.freezer.product.controller;


import com.stl.freezer.product.model.Product;
import com.stl.freezer.product.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Sebastian Thümmel on 01.09.2017.
 */

@Controller
@CrossOrigin(origins = "*")
@RequestMapping(path="/product")
@Slf4j
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(path = "/add")
    public ResponseEntity<?> addNewProduct(){
        Iterable<Product> products = productRepository.findAll();
        for(Product product : products){
            log.debug("Product:" + product.getName());
        }

        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
