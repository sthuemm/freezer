package com.stl.freezer.productmanagement.repository;


import com.stl.freezer.productmanagement.model.Product;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by Sebastian Thümmel on 01.09.2017.
 */

public interface ProductRepository extends CrudRepository<Product, Long> {

}
