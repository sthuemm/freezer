package com.stl.freezer.productmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Sebastian Thümmel on 01.09.2017.
 */

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private int quantity;

    public Product(){
        //default constructor
    }

}
