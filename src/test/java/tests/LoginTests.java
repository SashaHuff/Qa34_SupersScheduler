package tests;

import manager.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.SplashScreen;

public class LoginTests extends Configuration {
    @Test
    public void loginTestSuccess(){
        boolean addPresent = new SplashScreen(driver)
                .checkCurrentVersion("0.0.3")
                .fillEmail("huff@gmail.com")
                .fillPassword("Hhuff1234$")
                .clickBtnLogin()
                .ifFabAddPresent();
        Assert.assertTrue(addPresent);
    }
}
