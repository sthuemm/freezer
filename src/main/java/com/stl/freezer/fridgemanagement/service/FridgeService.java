package com.stl.freezer.fridgemanagement.service;

import com.stl.freezer.usermanagement.model.User;
import org.springframework.stereotype.Service;

@Service
public interface FridgeService {

    boolean defrostingInformationMustBeAnnounced(User user);

}
