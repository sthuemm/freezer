package com.stl.freezer.fridgemanagement.service;

import com.stl.freezer.FreezerApplication;
import com.stl.freezer.fridgemanagement.model.Fridge;
import com.stl.freezer.usermanagement.model.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = FreezerApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("Test")
public class FridgeServiceImplTest {

    private User user;

    @InjectMocks
    private FridgeServiceImpl fridgeService;

    @Before
    public void setup(){
        user = new User(1L, "testaccount@freezer.de","klajds5f$asj$ADa2s%as1" ,"test", "account", 30, null);
    }

    @Test
    public void testDefrostingInformationMustBeAnnouncedTrue(){
        Fridge fridge = new Fridge();
        fridge.setDeFrostInterval(90);
        fridge.setLastDefrostDate(LocalDate.now().minusDays(61));
        user.setFridge(fridge);
        Assert.assertTrue(fridgeService.defrostingInformationMustBeAnnounced(user));
    }

    @Test
    public void testDefrostingInformationMustBeAnnouncedFalse(){
        Fridge fridge = new Fridge();
        fridge.setDeFrostInterval(90);
        fridge.setLastDefrostDate(LocalDate.now().minusDays(30));
        user.setFridge(fridge);
        Assert.assertFalse(fridgeService.defrostingInformationMustBeAnnounced(user));
    }

    @After
    public void cleanUp(){
        user = null;
    }

}
