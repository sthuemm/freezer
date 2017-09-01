package com.stl.freezer.Repository;

import com.stl.freezer.Model.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Basti on 01.09.2017.
 */
public interface ProductRepository extends CrudRepository<Product, Long> {

}
