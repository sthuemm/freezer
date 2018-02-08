package com.stl.freezer.fridgemanagement.service;


import com.stl.freezer.usermanagement.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class FridgeServiceImpl implements FridgeService {


    @Override
    public boolean defrostingInformationMustBeAnnounced(User user) {
        LocalDate today = LocalDate.now();
        LocalDate deFrostingDate = user.getFridge().nextDeFrostDate();
        return today.plusDays(user.getNumberOfDaysBeforeDefrostingInfo()).isAfter(deFrostingDate);
    }
}
