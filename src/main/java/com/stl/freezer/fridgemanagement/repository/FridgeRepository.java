package com.stl.freezer.fridgemanagement.repository;

import com.stl.freezer.fridgemanagement.model.Fridge;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FridgeRepository extends CrudRepository<Fridge, Long> {
}
