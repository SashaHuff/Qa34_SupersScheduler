package tests;

import manager.Configuration;
import models.User;
import org.testng.Assert;
import org.testng.annotations.*;
import screens.HomeScreen;
import screens.LoginScreen;

public class DeleteEventTest extends Configuration {

    @BeforeClass
    public void preCondition(){
        User user = User.builder()
                .email("huff@gmail.com")
                .password("Hhuff1234$")
                .build();
        new LoginScreen(driver).complexLogin(user);
    }

    @Test
    public void deleteEvent(){

            new HomeScreen(driver)
                    .clickOnMenuEvents()
                    .returnToEvents()
                    .clickOnEvent()
                    .deleteEvent();
        }

  /*  @Test
    public void deleteEventWithToast(){
        boolean isToastTrue = new HomeScreen(driver)
                .toastMsgAppearance();
        Assert.assertTrue(isToastTrue);
    }

   */
    @AfterClass
    public void postCondition() {
        new HomeScreen(driver)
                .openMenu()
                .logOut();
    }
}
