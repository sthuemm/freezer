package com.stl.freezer.fridgemanagement.model;

import com.stl.freezer.usermanagement.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Fridge {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private LocalDate lastDefrostDate;

    private int deFrostInterval;

    public LocalDate nextDeFrostDate(){
        return lastDefrostDate.plusDays(deFrostInterval);
    }

}
