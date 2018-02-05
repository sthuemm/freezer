package com.stl.freezer.productmanagement.repository;


import com.stl.freezer.productmanagement.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by Sebastian Thümmel on 01.09.2017.
 */

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
