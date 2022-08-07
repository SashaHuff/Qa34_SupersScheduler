package tests;

import manager.Configuration;
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
        //email, password, clik btn - one method
     /*   User user = new User
        boolean addPresent = new LoginScreen(driver)
                .complexLogin(User user)//method
                .ifFabAddPresent();
        Assert.assertTrue(addPresent);

      */
    }
    @Test
    public void loginNegativeModelWrongPassword(){
       /* boolean addPresent = new LoginScreen(driver)
                .complexLogin(User user)
                .checkErrorMessage("Wrong email or password")
                .confirmErrorMSG();
        */
    }
    @AfterMethod
    public void postCondition(){
        //logOut
        new HomeScreen(driver)
                .openMenu()
                .logOut();
    }
}
