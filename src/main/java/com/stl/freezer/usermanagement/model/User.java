package com.stl.freezer.usermanagement.model;

import com.stl.freezer.fridgemanagement.model.Fridge;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String email;

    private String password;

    private String firstName;

    private String surName;

    private int numberOfDaysBeforeDefrostingInfo;

    @OneToOne
    private Fridge fridge;


}
