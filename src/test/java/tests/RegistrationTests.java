package tests;

import manager.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.LoginScreen;

public class RegistrationTests extends Configuration {
    @Test
    public void registrationSuccess(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
         new LoginScreen(driver)
                .fillEmail("huff"+i+"@gmail.com")
                .fillPassword("Hhuff1234$")
                .clickRegBtn()
                .skipWizard()
                .checkFabBtnPresentAssert()
                 .openMenu()
                 .logOut();


    }
}
