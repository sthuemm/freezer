package com.stl.freezer.Controller;

import com.stl.freezer.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Basti on 01.09.2017.
 */

@Controller
@CrossOrigin(origins = "*")
@RequestMapping(path="/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping(path = "/get")
    public ResponseEntity addnewProduct(){
        System.out.println("get");
        return new ResponseEntity("hello world", HttpStatus.OK);
    }
}
