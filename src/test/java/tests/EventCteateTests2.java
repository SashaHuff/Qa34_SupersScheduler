package tests;

import manager.Configuration;
import models.Event;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.LoginScreen;

public class EventCteateTests2 extends Configuration {
    @Test
    public void createNewEvent(){
        User user = User.builder()
                .email("huff@gmail.com")
                .password("Hhuff1234$")
                .build();
        Event event = Event.builder()
                .title("New Title1")
                .type("My Type2")
                .breaks(2)
                .wage(25).build();
        new LoginScreen(driver)
                .complexLogin(user)
                .checkFabBtnPresentAssert()
                .initCreationEvent()
                .createNewEvent(event);
        new HomeScreen(driver)
                .openMenu()
                .logOut();

    }
    @Test
    public void createNewEvent1(){
        User user = User.builder()
                .email("huff@gmail.com")
                .password("Hhuff1234$")
                .build();
        Event event = Event.builder()
                .title("New Title2")
                .type("My Type3")
                .breaks(2)
                .wage(25).build();
        new LoginScreen(driver)
                .complexLogin(user)
                .checkFabBtnPresentAssert()
                .initCreationEvent()
                .createNewEvent(event);
        new HomeScreen(driver)
                .openMenu()
                .logOut();

    }
}
