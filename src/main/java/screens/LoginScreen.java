package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginScreen extends BaseScreen{
    public LoginScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(xpath  ="//*[@resource-id='com.example.svetlana.scheduler:id/log_email_input']")
    MobileElement emailEditText;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/log_password_input']")
    MobileElement passwordEditText;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/login_btn']")
    MobileElement loginBtn;
    @FindBy(xpath = "//*[@resource-id='android:id/button1']")
    MobileElement errorOk;
    @FindBy(xpath = "//*[@resource-id='android:id/message']")
    MobileElement errorMsg;


    public LoginScreen fillEmail(String email){
        should(emailEditText,10);
        type(emailEditText,email);
        return this;
     //   return new LoginScreen(driver);
    }
    public LoginScreen fillPassword(String password){
        type(passwordEditText,password);
        return this;
    }
    public HomeScreen clickBtnLogin(){
        driver.hideKeyboard();
        loginBtn.click();
        return new HomeScreen(driver);
    }
    public WizardScreen clickRegBtn(){
        driver.hideKeyboard();
        loginBtn.click();
        return new WizardScreen(driver);
    }
    public HomeScreen complexLogin(User user){
        should(emailEditText,10);
        type(emailEditText, user.getEmail());
        type(passwordEditText, user.getPassword());
        clickBtnLogin();
        return new HomeScreen(driver);
    }
    public LoginScreen complexLoginNegative(User user){
        should(emailEditText,10);
        type(emailEditText, user.getEmail());
        type(passwordEditText, user.getPassword());
        clickBtnLogin();
        return new LoginScreen(driver);
    }
    public boolean checkErrorMessage(){
        should(errorMsg,10);
        return errorMsg.isDisplayed();

    }
    public LoginScreen checkErrorMSGAssert(){
        Assert.assertTrue(checkErrorMessage());
        return this;
    }
    public LoginScreen confirmError(){
        should(errorOk,10);
        errorOk.click();
        return  this;
    }
    public LoginScreen clearEmailAndPassword(){
        emailEditText.click();
        emailEditText.clear();
        passwordEditText.click();
        passwordEditText.clear();
        return this;
    }



}
