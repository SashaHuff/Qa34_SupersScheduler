package tests;

import manager.Configuration;
import models.Event;
import models.User;
import org.testng.annotations.Test;
import screens.LoginScreen;

public class EventCreateTestsCW extends Configuration {

    @Test
    public void createNewEvent(){

        new LoginScreen(driver)
                .complexLogin(User.builder().email("huff@gmail.com").password("Hhuff1234$").build())
                .initCreationEvent()
                .dataAction()
                .createNewEvent(Event.builder().title("Me Title").type("My Type").breaks(2).wage(50).build())
                .checkFabBtnPresentAssert()
                .openMenu()
                .logOut();


    }
    @Test
    public void createNewEventCheckData(){

        new LoginScreen(driver)
                .complexLogin(User.builder().email("huff@gmail.com").password("Hhuff1234$").build())
                .initCreationEvent()
                .selectDataAction("18/08/2022")
                .createNewEvent(Event.builder().title("Me Title").type("My Type").breaks(2).wage(50).build())
                .checkFabBtnPresentAssert()
                .openMenu()
                .logOut();


    }
}
