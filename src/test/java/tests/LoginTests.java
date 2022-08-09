package tests;

import manager.Configuration;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.LoginScreen;
import screens.SplashScreen;

public class LoginTests extends Configuration {
    @Test
    public void loginTestSuccess(){
        boolean addPresent = new LoginScreen(driver)
                .fillEmail("huff@gmail.com")
                .fillPassword("Hhuff1234$")
                .clickBtnLogin()
                .ifFabAddPresent();
        Assert.assertTrue(addPresent);
    }
    @Test
    public void loginTestSuccess2(){
        boolean addPresent = new LoginScreen(driver)
                .fillEmail("huff@gmail.com")
                .fillPassword("Hhuff1234$")
                .clickBtnLogin()
                .ifFabAddPresent();
        Assert.assertTrue(addPresent);
    }
    @Test
    public void loginSuccessModel(){
     User user = User.builder()
             .email("huff@gmail.com")
             .password("Hhuff1234$")
             .build();
    boolean addPresent = new LoginScreen(driver)
             .complexLogin(user)
             .ifFabAddPresent();
     Assert.assertTrue(addPresent);

       }
    @Test
    public void loginNegativeModelWrongPassword(){
        User user = User.builder()
                .email("huff@gmail.com")
                .password("Huff1234$")
                .build();
        new LoginScreen(driver)
                .complexLogin(user)
               .checkErrorMSGAssert()
                .confirmError();
      new LoginScreen(driver).clearEmailAndPassword();
        driver.hideKeyboard();
    }
    @AfterMethod
    public void postCondition(){
        //logOut
        new HomeScreen(driver)
            .openMenu()
            .logOut();
        }

    
}
