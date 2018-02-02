package com.stl.freezer.product.repository;


import com.stl.freezer.product.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sebastian Thümmel on 01.09.2017.
 */

public interface ProductRepository extends CrudRepository<Product, Long> {

}
